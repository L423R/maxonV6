package reports; //пакет

import entities.NagrEntity;
import entities.PrepsEntity;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;  
import org.hibernate.Query;
import org.hibernate.Session;
import reports.shame.Prepods;
import utils.HibernateUtil;

import javax.swing.*;
import java.net.URL;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.*;  
//библиотеки все что выше


public class FirstReports { //класс

   private static  String PATH; //путь
   static ArrayList<Prepods> list; //Лист

  

    public FirstReports() { //конструктор
        PATH =  "C:\\java\\JREport\\DipMax\\";  
        list = method();
        report(PATH);
    }

    public String getPath(){ // метод получения пути
        ClassLoader cl = this.getClass().getClassLoader();
        URL resource = cl.getResource("");
        return resource.toString();
    }

    public void report(String PATH) //метод создания доп соглашения и получения в указанном пути
    {
        try{
            JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(list); //создается коллекция
            JasperPrint jasperPrint = JasperFillManager.fillReport(PATH+"russtest.jasper",new HashMap(),source); //создается доп соглашения
            JasperExportManager.exportReportToPdfFile(jasperPrint,PATH+"russtest.pdf"); //файл на выход
        } catch (JRException e) {//ловит ошибки
            e.printStackTrace();
        }
    }


    public ArrayList<Prepods>  method(){ //метод заполнения доп соглашения
        Session session = null;

        

        try { //тут происходит алгоритм получения из бд нужных данных
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            List list;

            Query query = session.createQuery("select N.кодПреп, N.ставка, N.число from NagrEntity N");
            List<Object[]> objects= (List<Object[]>)query.list();

            Map<PrepsEntity, Double> map = new HashMap<>();

            for (Object[] ob: objects)
            {
                int prepEntity = 0;
                double stavka = 0;
                double chas=0;
                double sum=0;
                PrepsEntity entity = null;
                if (ob[0]!=null) {
                    prepEntity = (int) ob[0];
                   entity = (PrepsEntity) session.load(PrepsEntity.class,prepEntity);
                }

                if (ob[1]!= null) {

                    stavka = (double) ob[1];
                }
                if (ob[2]!= null)
                chas = (double) ob[2];

                if (entity!=null) {

                    sum = stavka*chas;
                    if (map.containsKey(entity)) {
                        Double oldSum = map.get(entity);
                        oldSum += sum;
                        map.put(entity,oldSum);
                    }else
                    {
                        map.put(entity,sum);
                    }
                }
            }

            ArrayList<Prepods> preps = new ArrayList<>();

            for (Map.Entry<PrepsEntity, Double> entry : map.entrySet())
            {
              

                preps.add(new Prepods(entry.getKey().toString(),entry.getValue()));
            }

            for (Prepods prep:preps)
                System.out.println( prep.getFIO()+" "+prep.getSumma());

            System.out.println(map.size());
            System.out.println(preps.size());
            session.getTransaction().commit();
          
            return preps;

        } catch (Exception e) {
           // JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при Get", JOptionPane.OK_OPTION);
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {

                session.close();
            }
        }
        return null;
    }
}
