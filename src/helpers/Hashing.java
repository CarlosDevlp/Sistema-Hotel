package helpers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Hashing<br> 
 * este helper permite encriptar todo tipo de información a los algoritmos
 * más conocidos de hasheo.<br>
 * Importado por Carlos Chavez Laguna. <br>
 * Créditos a 
 * @author AstromechZA
 * @see <a href="https://gist.github.com/AstromechZA/4f05a8fa34a5cde5207e">Link del gist del autor</a>
 * 
 * Helper class for hashing data with support for MD5, SHA1, SHA256, SHA385, and SHA512.
 */
public class Hashing
{
    /**
     * Do not use - Instances of this class are forbidden.
     *
     * @throws InstantiationException on call
     */
    public Hashing() throws InstantiationException
    {
        throw new InstantiationException("Instances of this type are forbidden.");
    }

    /**
     * Enum used for representing common message digest algorithms.
     * <p>
     * Use the valueOf(name) method to get the algorithm by name (eg: MD5, SHA1, SHA256..)
     * <p>
     * Use the getInstance() method to get a usable messageDigest instance.
     */
    public static enum HASH_ALG {
        MD5("md5", 16),
        SHA1("sha1", 20),
        SHA256("sha-256", 32),
        SHA384("sha-384", 48),
        SHA512("sha-512", 64);

        private final String name;
        private final int outputLength;

        HASH_ALG(String name, int outputLength)
        {
            this.name = name;
            this.outputLength = outputLength;
        }

        public MessageDigest getInstance()
        {
            try
            {
                return MessageDigest.getInstance(this.name);
            }
            catch (NoSuchAlgorithmException e)
            {
                throw new RuntimeException("Caught NoSuchAlgorithmException", e);
            }
        }

        public int getOutputByteLength()
        {
            return this.outputLength;
        }
    }

    /**
     * Calculate the hash of a section of a byte array.
     *
     * @param input     the byte array
     * @param off       offset to start at
     * @param len       number of bytes to hash
     * @param algorithm the hash algorithm to use
     * @return          the byte array showing the result
     */
    public static byte[] hash(final byte[] input, final int off, final int len, HASH_ALG algorithm)
    {
        MessageDigest md = algorithm.getInstance();
        md.update(input, off, len);
        return md.digest();
    }
    /**
     * Calculate the hash of a section of a byte array using the algorithm with the given name.
     *
     * @param input     the byte array
     * @param off       offset to start at
     * @param len       number of bytes to hash
     * @param algorithm the name of the hash algorithm to use
     * @return          the byte array showing the result
     */
    public static byte[] hash(final byte[] input, final int off, final int len, final String algorithm)
    {
        return hash(input, off, len, HASH_ALG.valueOf(algorithm.toUpperCase()));
    }

    /**
     * Calculate the hash of a byte array.
     *
     * @param input     the byte array
     * @param algorithm the hash algorithm to use
     * @return          the byte array showing the result
     */
    public static byte[] hash(final byte[] input, HASH_ALG algorithm)
    {
        return hash(input, 0, input.length, algorithm);
    }

    /**
     * Calculate the hash of a string.
     *
     * @param input     the string
     * @param algorithm the hash algorithm to use
     * @return          the byte array showing the result
     */
    public static byte[] hash(final String input, HASH_ALG algorithm)
    {
        return hash(input.getBytes(), 0, input.length(), algorithm);
    }

    /**
     * Calculate the hash of a byte array using the algorithm with the given name.
     *
     * @param input     the byte array
     * @param algorithm the name of the hash algorithm to use
     * @return          the byte array showing the result
     */
    public static byte[] hash(final byte[] input, String algorithm)
    {
        return hash(input, 0, input.length, algorithm);
    }

    /**
     * Calculate the hash of a string using the algorithm with the given name.
     *
     * @param input     the input string
     * @param algorithm the name of the hash algorithm to use
     * @return          the byte array showing the result
     */
    public static byte[] hash(final String input, String algorithm)
    {
        return hash(input.getBytes(), 0, input.length(), algorithm);
    }

}