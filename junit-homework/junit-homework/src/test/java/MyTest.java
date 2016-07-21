import com.endava.junit.process.ProcessPattern;
import com.endava.junit.process.SplitPattern;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by azburatura on 7/21/2016.
 */
public class MyTest {

    private SplitPattern splitPattern;
    private ProcessPattern processPattern;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testMyStringLength() throws Exception {
        splitPattern = new SplitPattern();
        System.out.println("You are in testMyStringLength");
        String result = splitPattern.getStringLength("Tetrahidrocanabinol");
        Assert.assertNotNull(result);
    }

    @Test
    public void testMyStringLength2() throws Exception {
        splitPattern = new SplitPattern();
        System.out.println("You are in testMyStringLength");
        String result = splitPattern.getStringLength("mar");
        Assert.assertNotNull(result);
    }

    @Test
    public void testMyStringLength3() throws Exception {
        splitPattern = new SplitPattern();
        System.out.println("You are in testMyStringLength");
        String result = splitPattern.getStringLength(null);
        Assert.assertNull(result);
    }

    @Test
    public void testMyStringLength4() throws Exception {
        splitPattern = new SplitPattern();
        System.out.println("You are in testMyStringLength");
        String result = splitPattern.getStringLength("acadeaMoca");
        Assert.assertNotNull(result);
    }

    @Test
    public void testSplitMyLength() throws Exception {
        splitPattern = new SplitPattern();
        System.out.println("You are in testSplitMyLength");
        List<String> listaString = new ArrayList<String>();
        listaString.add("Adrian");
        listaString.add("Ilinca");
        listaString.add("Bogdan");
        List<String> result = splitPattern.splitByLength(listaString);
        Assert.assertTrue(result.size() == 3);
    }

    @Test
    public void testGeneratePosition() throws Exception {
        processPattern = new ProcessPattern();
        System.out.println("You are in my testGeneratePosition");
        String result = processPattern.generatePosition("junior", 1);
        Assert.assertNotNull(result);
    }

    @Test
    public void testGeneratePosition2() throws Exception {
        processPattern = new ProcessPattern();
        System.out.println("You are in my testGeneratePosition");
        String result = processPattern.generatePosition("middle", 1);
        Assert.assertNotNull(result);
    }
    @Test
    public void testGeneratePosition3() throws Exception {
        processPattern = new ProcessPattern();
        System.out.println("You are in my testGeneratePosition");
        String result = processPattern.generatePosition("middle", 3);
        Assert.assertNotNull(result);
    }

    @Test
    public void testGeneratePosition4() throws Exception {
        processPattern = new ProcessPattern();
        System.out.println("You are in my testGeneratePosition");
        String result = processPattern.generatePosition("senior", 4);
        Assert.assertNotNull(result);
    }
    @Test
    public void testGeneratePosition5() throws Exception {
        processPattern = new ProcessPattern();
        System.out.println("You are in my testGeneratePosition");
        String result = processPattern.generatePosition("senior", 12);
        Assert.assertNotNull(result);
    }


    @Test
    public void testGeneratePosition6() throws Exception {
        processPattern = new ProcessPattern();
        System.out.println("You are in my testGeneratePosition");
        String result = processPattern.generatePosition("something", 1);
        Assert.assertNotNull(result);
    }

    @Test
    public void testGeneratePosition7() throws Exception {
        processPattern = new ProcessPattern();
        System.out.println("You are in my testGeneratePosition");
        String result = processPattern.generatePosition(null, 1);
        Assert.assertNull(result);
    }

    @Test
    public void testGeneratePosition8() throws Exception {
        processPattern = new ProcessPattern();
        System.out.println("You are in my testGeneratePosition");
        String result = processPattern.generatePosition("bla", -1);
        Assert.assertNull(result);
    }

}
