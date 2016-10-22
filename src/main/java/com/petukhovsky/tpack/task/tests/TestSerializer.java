package com.petukhovsky.tpack.task.tests;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.petukhovsky.jvaluer.commons.data.TestData;
import com.petukhovsky.jvaluer.commons.data.TruncatedOut;
import com.petukhovsky.jvaluer.util.TruncateUtils;

import java.io.IOException;

/**
 * Created by arthur on 22.10.16.
 */
public class TestSerializer extends StdSerializer<Test> {

    public TestSerializer() {
        super(Test.class);
    }

    protected TestSerializer(Class<Test> t) {
        super(t);
    }

    @Override
    public void serialize(Test test, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeNumberField("index", test.getIndex());

        if (test.getInData() != null) {
            TestData in = test.getInData();
            gen.writeStringField("in", TruncateUtils.truncate(in.getString(), 20));
        }

        if (test.getAnswerData() != null) {
            TestData answer = test.getAnswerData();
            gen.writeStringField("answer", TruncateUtils.truncate(answer.getString(), 20));
        }

        gen.writeEndObject();
    }
}
