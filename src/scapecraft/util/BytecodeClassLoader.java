package scapecraft.util;

/**
 * Created by mraof on 2016 March 02.
 */
public class BytecodeClassLoader extends ClassLoader
{
    public BytecodeClassLoader(ClassLoader parent)
    {
        super(parent);
    }
    public Class<?> defineClass(String name, byte[] b)
    {
        return defineClass(name, b, 0, b.length);
    }
}
