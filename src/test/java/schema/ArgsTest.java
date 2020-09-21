package schema;

import com.thoughtworks.basic.schema.Arg;
import com.thoughtworks.basic.schema.Args;
import com.thoughtworks.basic.schema.FlagsSchema;
import com.thoughtworks.basic.schema.Schema;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArgsTest {
    public Schema schema;
    @Before
    public void init(){
        FlagsSchema flagsSchemaL = new FlagsSchema("l",Boolean.TYPE);
        FlagsSchema flagsSchemaP = new FlagsSchema("p",Integer.TYPE);
        FlagsSchema flagsSchemaD = new FlagsSchema("d",String.class);
        Set<FlagsSchema> flagsSchemas = new HashSet();
        flagsSchemas.add(flagsSchemaL);
        flagsSchemas.add(flagsSchemaP);
        flagsSchemas.add(flagsSchemaD);
        schema = new Schema(flagsSchemas);
    }

    @Test
    public void should_return_size_and_value_given_txt(){
        String argsText = "-l true -p 8080 -d /usr/logs";
        Args args = new Args(argsText,schema);
        List<Arg> keyValueString = args.scan();

        Assert.assertEquals(3,keyValueString.size());
        Assert.assertEquals("true",keyValueString.get(0).getValue());
        Assert.assertEquals("8080",keyValueString.get(1).getValue());
        Assert.assertEquals("/usr/logs",keyValueString.get(2).getValue());
    }

    @Test
    public void should_return_boolean_true_given_l() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Args args1 = new Args("l true",schema);
        Assert.assertEquals(true,args1.getValueOf("l"));
    }

    @Test
    public void should_return_boolean_integer_true_given_l_d() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Args args1 = new Args("l true -p 8080",schema);
        Assert.assertEquals(8080,args1.getValueOf("p"));
    }

    @Test
    public void should_return_boolean_false_true_given_l() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Args args1 = new Args("l ",schema);
        Assert.assertEquals(false,args1.getValueOf("l"));
    }
}
