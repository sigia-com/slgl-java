package io.slgl.client.jsonlogic;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static io.slgl.client.utils.Preconditions.checkArgument;

@JsonDeserialize(as = Subtract.class)
public class Subtract implements JsonLogic {

    public static final String OP = "-";

    @JsonProperty(OP)
    private List<Object> add;

    @JsonCreator
    Subtract(@JsonProperty(OP) List<Object> list) {
        checkArgument(list.size() == 2);
        add = list;
    }

    public Subtract(Object a, Object b) {
        add = Arrays.asList(a, b);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subtract subtract = (Subtract) o;
        return Objects.equals(add, subtract.add);
    }

    @Override
    public int hashCode() {
        return Objects.hash(add);
    }
}
