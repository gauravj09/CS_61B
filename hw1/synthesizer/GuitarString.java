package synthesizer;

import java.util.HashSet;
import java.util.Set;

//Make sure this class is public
public class GuitarString {
    /** Constants. Do not change. In case you're curious, the keyword final means
     * the values cannot be changed at runtime. We'll discuss this and other topics
     * in lecture on Friday. */
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor

    /* Buffer for storing sound data. */
    private BoundedQueue<Double> buffer;

    /* Create a guitar string of the given frequency.  */
    public GuitarString(double frequency) {
        int bufferCapacity = (int) Math.round(SR / frequency);
        buffer = new ArrayRingBuffer(bufferCapacity);

        while (!buffer.isFull()) {
            buffer.enqueue(0.0);
        }
    }

    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {
        /* Store the random numbers in a bufferSet to ensure there are no duplicates*/
        Set<Double> bufferSet = new HashSet<>();

        while (!buffer.isEmpty()) {
            buffer.dequeue();
        }

        for (int i = 0; i < buffer.capacity(); i++) {
            double r = Math.random() - 0.5;
            bufferSet.add(r);
        }

        for (double d : bufferSet) {
            buffer.enqueue(d);
        }
    }

    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm.
     */
    public void tic() {
        double bufferDeque = buffer.dequeue();
        double samplePeek = sample();
        double updateSample = DECAY * (bufferDeque + samplePeek) / 2;
        buffer.enqueue(updateSample);
    }

    /* Return the double at the front of the buffer. */
    public double sample() {
        return buffer.peek();
    }
}
