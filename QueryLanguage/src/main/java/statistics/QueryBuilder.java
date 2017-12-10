package statistics;

import statistics.matcher.*;
import statistics.matcher.Matcher;

import java.util.ArrayList;
import java.util.Arrays;

public class QueryBuilder {

    private Matcher matcher;

    public QueryBuilder() {
        matcher = null;
    }

    QueryBuilder hasAtLeast(int value, String category) {
        if (matcher != null) {
            matcher = new And(new HasAtLeast(value, category), matcher);
        } else {
            matcher = new HasAtLeast(value, category);
        }
        return this;
    }

    QueryBuilder hasFewerThan(int value, String category) {
        if (matcher != null) {
            matcher = new And(new HasFewerThan(value, category), matcher);
        } else {
            matcher = new HasFewerThan(value, category);
        }
        return this;
    }

    QueryBuilder playsIn(String team) {
        if (matcher != null) {
            matcher = new And(new PlaysIn(team), matcher);
        } else {
            matcher = new PlaysIn(team);
        }
        return this;
    }

    QueryBuilder oneOf(Matcher... matchers) {
        matcher = new Or(matchers);
        return this;
    }

    public Matcher build() {
        Matcher done = matcher;
        matcher = null;
        return done;
    }

    private Matcher[] combine(Matcher m, Matcher... matchers) {
        ArrayList<Matcher> combined = new ArrayList<>();
        combined.add(m);
        combined.addAll(Arrays.asList(matchers));
        return combined.toArray(new Matcher[]{});
    }
}
