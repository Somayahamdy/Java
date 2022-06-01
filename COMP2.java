import java.math.BigDecimal;

public class COMP2
{
	public static void main(String args[])
	{
		Complex <BigDecimal> c = new Complex<>(new BigDecimal(10),new BigDecimal(1));

		c.add(new Complex <BigDecimal> (new BigDecimal(10),new BigDecimal(1)));

		System.out.println("addition equals: " + c.toString());
	}
}

class Complex <T extends BigDecimal>
{
	private T real;
	private	T imag;

	
	Complex(T r, T i)
	{
		real = r;
		imag = i;
	}
	
	public	T getReal() {return real;}
	public	T getImag() {return imag;}
	public	String toString()
			{
				StringBuffer s = new StringBuffer().append(real);
				s.append('+');
				return s.append(imag).append('i').toString();
			}
	// add to current number
	public	Complex <T> add(Complex<T> c)
			{
				return new Complex <T> ((T)(real.add(c.real)), (T)(imag.add(c.imag)));
			}

	// sub with current number
	public	Complex <T> subtract(Complex<T> c)
			{
				return new Complex <T> ((T)(real.subtract(c.real)), (T)(imag.subtract(c.imag)));
			}

	// multiply with current number
	public	Complex <T> multiply(Complex<T> c)
			{
				return new Complex <T> ((T)(real.multiply(c.getReal()).subtract(imag.multiply(c.getImag()))),
				 (T)(real.multiply(c.getImag()).add(imag.multiply(c.getReal()))));
			}

}