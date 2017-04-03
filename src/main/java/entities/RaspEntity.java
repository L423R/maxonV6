package entities;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Maxon on 06.03.2017.
 */
@Entity
@Table(name = "rasp", schema = "maxdip")
public class RaspEntity {
    private int id;
    private GroupsEntity кодГруп;
    private DiscEntity кодДисц;
    private PrepsEntity кодПреп;
    private Integer кодСтав;
    private Byte семестр;
    private Timestamp датаЗан;
    private Timestamp начЗан;
    private Byte колЧас;
    private String типСтуд;
    private String типЗан;
    private String аудит;
    private Double ставка;
    private String день;
    private Boolean прОпл;
    private Timestamp датаОпл;
    private String оборуд;
    private String примеч;
    private Boolean прПот;
    private Timestamp датаЗанКр;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "КодГруп", nullable = true)
    public GroupsEntity getКодГруп() {
        return кодГруп;
    }

    public void setКодГруп(GroupsEntity кодГруп) {
        this.кодГруп = кодГруп;
    }


    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "КодДисц", nullable = true)
    public DiscEntity getКодДисц() {
        return кодДисц;
    }

    public void setКодДисц(DiscEntity кодДисц) {
        this.кодДисц = кодДисц;
    }


    @ManyToOne
    @JoinColumn(name = "КодПреп", nullable = true)
    public PrepsEntity getКодПреп() {
        return кодПреп;
    }

    public void setКодПреп(PrepsEntity кодПреп) {
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
    @Column(name = "Семестр", nullable = true)
    public Byte getСеместр() {
        return семестр;
    }

    public void setСеместр(Byte семестр) {
        this.семестр = семестр;
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
    @Column(name = "КолЧас", nullable = true)
    public Byte getКолЧас() {
        return колЧас;
    }

    public void setКолЧас(Byte колЧас) {
        this.колЧас = колЧас;
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
    @Column(name = "ТипЗан", nullable = true, length = 255)
    public String getТипЗан() {
        return типЗан;
    }

    public void setТипЗан(String типЗан) {
        this.типЗан = типЗан;
    }

    @Basic
    @Column(name = "Аудит", nullable = true, length = 255)
    public String getАудит() {
        return аудит;
    }

    public void setАудит(String аудит) {
        this.аудит = аудит;
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
    @Column(name = "День", nullable = true, length = 255)
    public String getДень() {
        return день;
    }

    public void setДень(String день) {
        this.день = день;
    }

    @Basic
    @Column(name = "ПрОпл", nullable = true)
    public Boolean getПрОпл() {
        return прОпл;
    }

    public void setПрОпл(Boolean прОпл) {
        this.прОпл = прОпл;
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
    @Column(name = "Оборуд", nullable = true, length = 255)
    public String getОборуд() {
        return оборуд;
    }

    public void setОборуд(String оборуд) {
        this.оборуд = оборуд;
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
    @Column(name = "ПрПот", nullable = true)
    public Boolean getПрПот() {
        return прПот;
    }

    public void setПрПот(Boolean прПот) {
        this.прПот = прПот;
    }

    @Basic
    @Column(name = "ДатаЗан_КР", nullable = true)
    public Timestamp getДатаЗанКр() {
        return датаЗанКр;
    }

    public void setДатаЗанКр(Timestamp датаЗанКр) {
        this.датаЗанКр = датаЗанКр;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RaspEntity that = (RaspEntity) o;

        if (id != that.id) return false;
        if (кодГруп != null ? !кодГруп.equals(that.кодГруп) : that.кодГруп != null) return false;
        if (кодДисц != null ? !кодДисц.equals(that.кодДисц) : that.кодДисц != null) return false;
        if (кодПреп != null ? !кодПреп.equals(that.кодПреп) : that.кодПреп != null) return false;
        if (кодСтав != null ? !кодСтав.equals(that.кодСтав) : that.кодСтав != null) return false;
        if (семестр != null ? !семестр.equals(that.семестр) : that.семестр != null) return false;
        if (датаЗан != null ? !датаЗан.equals(that.датаЗан) : that.датаЗан != null) return false;
        if (начЗан != null ? !начЗан.equals(that.начЗан) : that.начЗан != null) return false;
        if (колЧас != null ? !колЧас.equals(that.колЧас) : that.колЧас != null) return false;
        if (типСтуд != null ? !типСтуд.equals(that.типСтуд) : that.типСтуд != null) return false;
        if (типЗан != null ? !типЗан.equals(that.типЗан) : that.типЗан != null) return false;
        if (аудит != null ? !аудит.equals(that.аудит) : that.аудит != null) return false;
        if (ставка != null ? !ставка.equals(that.ставка) : that.ставка != null) return false;
        if (день != null ? !день.equals(that.день) : that.день != null) return false;
        if (прОпл != null ? !прОпл.equals(that.прОпл) : that.прОпл != null) return false;
        if (датаОпл != null ? !датаОпл.equals(that.датаОпл) : that.датаОпл != null) return false;
        if (оборуд != null ? !оборуд.equals(that.оборуд) : that.оборуд != null) return false;
        if (примеч != null ? !примеч.equals(that.примеч) : that.примеч != null) return false;
        if (прПот != null ? !прПот.equals(that.прПот) : that.прПот != null) return false;
        if (датаЗанКр != null ? !датаЗанКр.equals(that.датаЗанКр) : that.датаЗанКр != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (кодГруп != null ? кодГруп.hashCode() : 0);
        result = 31 * result + (кодДисц != null ? кодДисц.hashCode() : 0);
        result = 31 * result + (кодПреп != null ? кодПреп.hashCode() : 0);
        result = 31 * result + (кодСтав != null ? кодСтав.hashCode() : 0);
        result = 31 * result + (семестр != null ? семестр.hashCode() : 0);
        result = 31 * result + (датаЗан != null ? датаЗан.hashCode() : 0);
        result = 31 * result + (начЗан != null ? начЗан.hashCode() : 0);
        result = 31 * result + (колЧас != null ? колЧас.hashCode() : 0);
        result = 31 * result + (типСтуд != null ? типСтуд.hashCode() : 0);
        result = 31 * result + (типЗан != null ? типЗан.hashCode() : 0);
        result = 31 * result + (аудит != null ? аудит.hashCode() : 0);
        result = 31 * result + (ставка != null ? ставка.hashCode() : 0);
        result = 31 * result + (день != null ? день.hashCode() : 0);
        result = 31 * result + (прОпл != null ? прОпл.hashCode() : 0);
        result = 31 * result + (датаОпл != null ? датаОпл.hashCode() : 0);
        result = 31 * result + (оборуд != null ? оборуд.hashCode() : 0);
        result = 31 * result + (примеч != null ? примеч.hashCode() : 0);
        result = 31 * result + (прПот != null ? прПот.hashCode() : 0);
        result = 31 * result + (датаЗанКр != null ? датаЗанКр.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RaspEntity{" +
                "id=" + id +
                ", кодГруп=" + кодГруп +
                ", кодДисц=" + кодДисц +
                ", кодПреп=" + кодПреп +
                ", кодСтав=" + кодСтав +
                ", семестр=" + семестр +
                ", датаЗан=" + датаЗан +
                ", начЗан=" + начЗан +
                ", колЧас=" + колЧас +
                ", типСтуд='" + типСтуд + '\'' +
                ", типЗан='" + типЗан + '\'' +
                ", аудит='" + аудит + '\'' +
                ", ставка=" + ставка +
                ", день='" + день + '\'' +
                ", прОпл=" + прОпл +
                ", датаОпл=" + датаОпл +
                ", оборуд='" + оборуд + '\'' +
                ", примеч='" + примеч + '\'' +
                ", прПот=" + прПот +
                ", датаЗанКр=" + датаЗанКр +
                '}';
    }
}
