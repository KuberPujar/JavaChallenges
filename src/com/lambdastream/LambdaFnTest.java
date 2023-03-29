package com.lambdastream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
public class LambdaFnTest {
    LambdaFn fn;
    FnCheck fc;
    public LambdaFnTest() {
    }

    @Before
    public void setUp() {
        fn = new LambdaFn();
        fc = new FnCheck();
    }

    long a,b;

    @Test
    public void testFunctionalProgramming1() throws IOException {
        if(fc.isFnProgrammingPresent())
        {
            a=46;
            b=1000;
            List<String> listOfIntegers = new ArrayList<>();
            for(long i=a;i<=b;i++)
            {
                listOfIntegers.add(i+"");
            }
            int actual = fn.functionalProgramming(listOfIntegers).hashCode();
            assertEquals(5849022, actual);
        }
        else
        {
            assertEquals(8394283, 76387468);
        }
    }

    @Test
    public void testFunctionalProgramming2() throws IOException {
        if(fc.isFnProgrammingPresent())
        {
            a=2000;
            b=150000;
            List<String> listOfIntegers = new ArrayList<>();
            for(long i=a;i<=b;i++)
            {
                listOfIntegers.add(i+"");
            }
            int actual = fn.functionalProgramming(listOfIntegers).hashCode();
            assertEquals(-643224690, actual);
        }
        else
        {
            assertEquals(8394283, 76387468);
        }
    }

    @Test
    public void testFunctionalProgramming3() throws IOException {
        if(fc.isFnProgrammingPresent())
        {
            a=7500;
            b=655000;
            List<String> listOfIntegers = new ArrayList<>();
            for(long i=a;i<=b;i++)
            {
                listOfIntegers.add(i+"");
            }
            int actual = fn.functionalProgramming(listOfIntegers).hashCode();
            assertEquals(1535419924, actual);
        }
        else
        {
            assertEquals(8394283, 76387468);
        }
    }

    @Test
    public void testFunctionalProgramming4() throws IOException {
        if(fc.isFnProgrammingPresent())
        {
            a=100000;
            b=850000;
            List<String> listOfIntegers = new ArrayList<>();
            for(long i=a;i<=b;i++)
            {
                listOfIntegers.add(i+"");
            }
            int actual = fn.functionalProgramming(listOfIntegers).hashCode();
            assertEquals(548865, actual);
        }
        else
        {
            assertEquals(8394283, 76387468);
        }
    }

    @Test
    public void testFunctionalProgramming5() throws IOException {
        if(fc.isFnProgrammingPresent())
        {
            a=1;
            b=10000;
            List<String> listOfIntegers = new ArrayList<>();
            for(long i=a;i<=b;i++)
            {
                listOfIntegers.add(i+"");
            }
            int actual = fn.functionalProgramming(listOfIntegers).hashCode();
            assertEquals(179840467, actual);
        }
        else
        {
            assertEquals(8394283, 76387468);
        }
    }

    @Test
    public void testFunctionalProgramming6() throws IOException {
        if(fc.isFnProgrammingPresent())
        {
            a=99;
            b=99999;
            List<String> listOfIntegers = new ArrayList<>();
            for(long i=a;i<=b;i++)
            {
                listOfIntegers.add(i+"");
            }
            int actual = fn.functionalProgramming(listOfIntegers).hashCode();
            assertEquals(1095824139, actual);
        }
        else
        {
            assertEquals(8394283, 76387468);
        }
    }

    @Test
    public void testFunctionalProgramming7() throws IOException {
        if(fc.isFnProgrammingPresent())
        {
            a=100000;
            b=500000;
            List<String> listOfIntegers = new ArrayList<>();
            for(long i=a;i<=b;i++)
            {
                listOfIntegers.add(i+"");
            }
            int actual = fn.functionalProgramming(listOfIntegers).hashCode();
            assertEquals(1, actual);
        }
        else
        {
            assertEquals(8394283, 76387468);
        }
    }

    @Test
    public void testFunctionalProgramming8() throws IOException {
        if(fc.isFnProgrammingPresent())
        {
            a=813;
            b=75000;
            List<String> listOfIntegers = new ArrayList<>();
            for(long i=a;i<=b;i++)
            {
                listOfIntegers.add(i+"");
            }
            int actual = fn.functionalProgramming(listOfIntegers).hashCode();
            assertEquals(57838345, actual);
        }
        else
        {
            assertEquals(8394283, 76387468);
        }
    }

    @Test
    public void testFunctionalProgramming9() throws IOException {
        if(fc.isFnProgrammingPresent())
        {
            a=1;
            b=10000000;
            List<String> listOfIntegers = new ArrayList<>();
            for(long i=a;i<=b;i++)
            {
                listOfIntegers.add(i+"");
            }
            int actual = fn.functionalProgramming(listOfIntegers).hashCode();
            assertEquals(225968851, actual);
        }
        else
        {
            assertEquals(8394283, 76387468);
        }
    }

    @Test
    public void testFunctionalProgramming10() throws IOException {
        if(fc.isFnProgrammingPresent())
        {
            a=10000;
            b=10000000;
            List<String> listOfIntegers = new ArrayList<>();
            for(long i=a;i<=b;i++)
            {
                listOfIntegers.add(i+"");
            }
            int actual = fn.functionalProgramming(listOfIntegers).hashCode();
            assertEquals(-1231958271, actual);
        }
        else
        {
            assertEquals(8394283, 76387468);
        }
    }

    @Test
    public void testFunctionalProgramming11() throws IOException {
        if(fc.isFnProgrammingPresent())
        {
            a=1;
            b=100000;
            List<String> listOfIntegers = new ArrayList<>();
            for(long i=a;i<=b;i++)
            {
                listOfIntegers.add(i+"");
            }
            int actual = fn.functionalProgramming(listOfIntegers).hashCode();
            assertEquals(1858714734, actual);
        }
        else
        {
            assertEquals(8394283, 76387468);
        }
    }

    @Test
    public void testFunctionalProgramming12() throws IOException {
        if(fc.isFnProgrammingPresent())
        {
            a=50000;
            b=55000;
            List<String> listOfIntegers = new ArrayList<>();
            for(long i=a;i<=b;i++)
            {
                listOfIntegers.add(i+"");
            }
            int actual = fn.functionalProgramming(listOfIntegers).hashCode();
            assertEquals(54779, actual);
        }
        else
        {
            assertEquals(8394283, 76387468);
        }
    }

    @Test
    public void testFunctionalProgramming13() throws IOException {
        if(fc.isFnProgrammingPresent())
        {
            a=1;
            b=1000000;
            List<String> listOfIntegers = new ArrayList<>();
            for(long i=a;i<=b;i++)
            {
                listOfIntegers.add(i+"");
            }
            int actual = fn.functionalProgramming(listOfIntegers).hashCode();
            assertEquals(1786130740, actual);
        }
        else
        {
            assertEquals(8394283, 76387468);
        }
    }

}
