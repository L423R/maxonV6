package entities;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Maxon on 30.03.2017.
 */
@Entity
@Table(name = "nagr", schema = "maxdip", catalog = "")
public class NagrEntity {
    private Integer кодРаспис;
    private Timestamp датаЗан;
    private Timestamp начЗан;
    private Integer кодПреп;
    private Integer кодСтав;
    private Double число;
    private String типСтуд;
    private Double ставка;
    private Timestamp датаОпл;
    private String примеч;
    private Timestamp датаЗанКр;
    private Integer кодДисц;
    private int id;
    private PrepsEntity prepsByКодПреп;
    private DiscEntity discByКодДисц;

    @Basic
    @Column(name = "КодРаспис", nullable = true)
    public Integer getКодРаспис() {
        return кодРаспис;
    }

    public void setКодРаспис(Integer кодРаспис) {
        this.кодРаспис = кодРаспис;
    }

    @Basic
    @Column(name = "ДатаЗан", nullable = true)
    public Timestamp getДатаЗан() {
        return датаЗан;
    }

    public void setДатаЗан(Timestamp датаЗан) {
        this.датаЗан = датаЗан;
    }

    @Basic
    @Column(name = "НачЗан", nullable = true)
    public Timestamp getНачЗан() {
        return начЗан;
    }

    public void setНачЗан(Timestamp начЗан) {
        this.начЗан = начЗан;
    }

    @Basic
    @Column(name = "КодПреп", nullable = true)
    public Integer getКодПреп() {
        return кодПреп;
    }

    public void setКодПреп(Integer кодПреп) {
        this.кодПреп = кодПреп;
    }

    @Basic
    @Column(name = "КодСтав", nullable = true)
    public Integer getКодСтав() {
        return кодСтав;
    }

    public void setКодСтав(Integer кодСтав) {
        this.кодСтав = кодСтав;
    }

    @Basic
    @Column(name = "Число", nullable = true, precision = 0)
    public Double getЧисло() {
        return число;
    }

    public void setЧисло(Double число) {
        this.число = число;
    }

    @Basic
    @Column(name = "ТипСтуд", nullable = true, length = 255)
    public String getТипСтуд() {
        return типСтуд;
    }

    public void setТипСтуд(String типСтуд) {
        this.типСтуд = типСтуд;
    }

    @Basic
    @Column(name = "Ставка", nullable = true, precision = 0)
    public Double getСтавка() {
        return ставка;
    }

    public void setСтавка(Double ставка) {
        this.ставка = ставка;
    }

    @Basic
    @Column(name = "ДатаОпл", nullable = true)
    public Timestamp getДатаОпл() {
        return датаОпл;
    }

    public void setДатаОпл(Timestamp датаОпл) {
        this.датаОпл = датаОпл;
    }

    @Basic
    @Column(name = "Примеч", nullable = true, length = 50)
    public String getПримеч() {
        return примеч;
    }

    public void setПримеч(String примеч) {
        this.примеч = примеч;
    }

    @Basic
    @Column(name = "ДатаЗан_КР", nullable = true)
    public Timestamp getДатаЗанКр() {
        return датаЗанКр;
    }

    public void setДатаЗанКр(Timestamp датаЗанКр) {
        this.датаЗанКр = датаЗанКр;
    }

    @Basic
    @Column(name = "КодДисц", nullable = true)
    public Integer getКодДисц() {
        return кодДисц;
    }

    public void setКодДисц(Integer кодДисц) {
        this.кодДисц = кодДисц;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NagrEntity that = (NagrEntity) o;

        if (id != that.id) return false;
        if (кодРаспис != null ? !кодРаспис.equals(that.кодРаспис) : that.кодРаспис != null) return false;
        if (датаЗан != null ? !датаЗан.equals(that.датаЗан) : that.датаЗан != null) return false;
        if (начЗан != null ? !начЗан.equals(that.начЗан) : that.начЗан != null) return false;
        if (кодПреп != null ? !кодПреп.equals(that.кодПреп) : that.кодПреп != null) return false;
        if (кодСтав != null ? !кодСтав.equals(that.кодСтав) : that.кодСтав != null) return false;
        if (число != null ? !число.equals(that.число) : that.число != null) return false;
        if (типСтуд != null ? !типСтуд.equals(that.типСтуд) : that.типСтуд != null) return false;
        if (ставка != null ? !ставка.equals(that.ставка) : that.ставка != null) return false;
        if (датаОпл != null ? !датаОпл.equals(that.датаОпл) : that.датаОпл != null) return false;
        if (примеч != null ? !примеч.equals(that.примеч) : that.примеч != null) return false;
        if (датаЗанКр != null ? !датаЗанКр.equals(that.датаЗанКр) : that.датаЗанКр != null) return false;
        if (кодДисц != null ? !кодДисц.equals(that.кодДисц) : that.кодДисц != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = кодРаспис != null ? кодРаспис.hashCode() : 0;
        result = 31 * result + (датаЗан != null ? датаЗан.hashCode() : 0);
        result = 31 * result + (начЗан != null ? начЗан.hashCode() : 0);
        result = 31 * result + (кодПреп != null ? кодПреп.hashCode() : 0);
        result = 31 * result + (кодСтав != null ? кодСтав.hashCode() : 0);
        result = 31 * result + (число != null ? число.hashCode() : 0);
        result = 31 * result + (типСтуд != null ? типСтуд.hashCode() : 0);
        result = 31 * result + (ставка != null ? ставка.hashCode() : 0);
        result = 31 * result + (датаОпл != null ? датаОпл.hashCode() : 0);
        result = 31 * result + (примеч != null ? примеч.hashCode() : 0);
        result = 31 * result + (датаЗанКр != null ? датаЗанКр.hashCode() : 0);
        result = 31 * result + (кодДисц != null ? кодДисц.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "КодПреп", referencedColumnName = "id",insertable=false, updatable=false)
    public PrepsEntity getPrepsByКодПреп() {
        return prepsByКодПреп;
    }

    public void setPrepsByКодПреп(PrepsEntity prepsByКодПреп) {
        this.prepsByКодПреп = prepsByКодПреп;
    }

    @ManyToOne
    @JoinColumn(name = "КодДисц", referencedColumnName = "id",insertable=false, updatable=false)
    public DiscEntity getDiscByКодДисц() {
        return discByКодДисц;
    }

    public void setDiscByКодДисц(DiscEntity discByКодДисц) {
        this.discByКодДисц = discByКодДисц;
    }
}
