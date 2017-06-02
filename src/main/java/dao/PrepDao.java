package dao;

/**
 * Created by Maxon on 03.04.2017.
 */
public interface PrepDao extends Dao  {

    Object[] getStepMas();
    Object[] getZvanMas();
    Object[] getDoljnMas();
    Object[] getDoljnFdoMas();

}
