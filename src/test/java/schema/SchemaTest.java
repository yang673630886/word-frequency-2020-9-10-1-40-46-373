package schema;

import com.thoughtworks.basic.schema.FlagsSchema;
import com.thoughtworks.basic.schema.Schema;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class SchemaTest {
    @Test
    public void should_return_boolean_type_when_given_flag(){
        Set<FlagsSchema> flagSchema = new HashSet<>();
        flagSchema.add(new FlagsSchema("l",Boolean.TYPE));
        Schema schema = new Schema(flagSchema);

        Assert.assertEquals(schema.getValueOf("l"),Boolean.TYPE);
    }

}
