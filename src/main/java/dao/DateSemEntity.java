package dao;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Maxon on 15.02.2017.
 */
@Entity
@Table(name = "date_sem", schema = "maxdip", catalog = "")
public class DateSemEntity {
    private int кодСем;
    private String наимСем;
    private Timestamp начСем;
    private Timestamp конСем;
    private String год;
    private String сем;

    @Id
    @Column(name = "КодСем", nullable = false)
    public int getКодСем() {
        return кодСем;
    }

    public void setКодСем(int кодСем) {
        this.кодСем = кодСем;
    }

    @Basic
    @Column(name = "НаимСем", nullable = true, length = 255)
    public String getНаимСем() {
        return наимСем;
    }

    public void setНаимСем(String наимСем) {
        this.наимСем = наимСем;
    }

    @Basic
    @Column(name = "НачСем", nullable = true)
    public Timestamp getНачСем() {
        return начСем;
    }

    public void setНачСем(Timestamp начСем) {
        this.начСем = начСем;
    }

    @Basic
    @Column(name = "КонСем", nullable = true)
    public Timestamp getКонСем() {
        return конСем;
    }

    public void setКонСем(Timestamp конСем) {
        this.конСем = конСем;
    }

    @Basic
    @Column(name = "Год", nullable = true, length = 55)
    public String getГод() {
        return год;
    }

    public void setГод(String год) {
        this.год = год;
    }

    @Basic
    @Column(name = "Сем", nullable = true, length = 55)
    public String getСем() {
        return сем;
    }

    public void setСем(String сем) {
        this.сем = сем;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DateSemEntity that = (DateSemEntity) o;

        if (кодСем != that.кодСем) return false;
        if (наимСем != null ? !наимСем.equals(that.наимСем) : that.наимСем != null) return false;
        if (начСем != null ? !начСем.equals(that.начСем) : that.начСем != null) return false;
        if (конСем != null ? !конСем.equals(that.конСем) : that.конСем != null) return false;
        if (год != null ? !год.equals(that.год) : that.год != null) return false;
        if (сем != null ? !сем.equals(that.сем) : that.сем != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = кодСем;
        result = 31 * result + (наимСем != null ? наимСем.hashCode() : 0);
        result = 31 * result + (начСем != null ? начСем.hashCode() : 0);
        result = 31 * result + (конСем != null ? конСем.hashCode() : 0);
        result = 31 * result + (год != null ? год.hashCode() : 0);
        result = 31 * result + (сем != null ? сем.hashCode() : 0);
        return result;
    }


}
