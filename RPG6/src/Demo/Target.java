package Demo;


/**
 * @author Mr. Nockles
 *
 */
public interface Target {
	
	//Your hit method may need some parameters, such as how much damage to take
	public void hit(SampleEnemy e);
	public String getName();
}