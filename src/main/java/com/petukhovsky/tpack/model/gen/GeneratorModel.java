package com.petukhovsky.tpack.model.gen;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by arthur on 28.9.16.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GeneratorModel {
    private final String id;
    private final String executableId;
    private final String defaultArgs;
    private final String in;
    private final String out;

    @JsonCreator
    public GeneratorModel(@JsonProperty("id") String id,
                          @JsonProperty("executableId") String executableId,
                          @JsonProperty("defaultArgs") String defaultArgs,
                          @JsonProperty("in") String in,
                          @JsonProperty("out") String out) {
        this.id = id;
        this.executableId = executableId;
        this.defaultArgs = defaultArgs;
        this.in = (in == null ? "stdin" : in);
        this.out = (out == null ? "stdout" : out);
    }

    public String getId() {
        return id;
    }

    public String getExecutableId() {
        return executableId;
    }

    public String getDefaultArgs() {
        return defaultArgs;
    }

    public String getIn() {
        return in;
    }

    public String getOut() {
        return out;
    }
}
