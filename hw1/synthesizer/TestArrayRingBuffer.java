package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Double> arb = new ArrayRingBuffer<>(10);
        arb.enqueue(33.1);
        double s = arb.peek();
        org.junit.Assert.assertEquals(s, 33.1, 0.0001);
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
        ArrayRingBuffer<Double> arb = new ArrayRingBuffer(10);
        arb.enqueue(33.1);
        System.out.println(arb.dequeue());
    }
} 
