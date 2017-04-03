package entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;

/**
 * Created by Maxon on 01.03.2017.
 */
@Entity
@Table(name = "groups", schema = "maxdip")
public class GroupsEntity {
    private int id;
    private String сокрНг;
    private ProgsEntity кодПрогр;
    private MetodistsEntity кодМет;
    private String расшПрог;
    private String профПрог;
    private Timestamp датаОткр;
    private Timestamp датаЗакр;
    private Short колЧел;
    private Boolean шкала;
    private Boolean прЭксп;
    private String примеч;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "СокрНГ", nullable = true, length = 5)
    public String getСокрНг() {
        return сокрНг;
    }

    public void setСокрНг(String сокрНг) {
        this.сокрНг = сокрНг;
    }

    @ManyToOne
    @JoinColumn(name = "КодПрогр")
    public ProgsEntity getКодПрогр() {
        return кодПрогр;
    }

    public void setКодПрогр(ProgsEntity кодПрогр) {
        this.кодПрогр = кодПрогр;
    }

    @ManyToOne
    @JoinColumn(name = "КодМет")
    public MetodistsEntity getКодМет() {
        return кодМет;
    }

    public void setКодМет(MetodistsEntity кодМет) {
        this.кодМет = кодМет;
    }

    @Basic
    @Column(name = "РасшПрог", nullable = true, length = 255)
    public String getРасшПрог() {
        return расшПрог;
    }

    public void setРасшПрог(String расшПрог) {
        this.расшПрог = расшПрог;
    }

    @Basic
    @Column(name = "ПрофПрог", nullable = true, length = 255)
    public String getПрофПрог() {
        return профПрог;
    }

    public void setПрофПрог(String профПрог) {
        this.профПрог = профПрог;
    }

    @Basic
    @Column(name = "ДатаОткр", nullable = true)
    public Timestamp getДатаОткр() {
        return датаОткр;
    }

    public void setДатаОткр(Timestamp датаОткр) {
        this.датаОткр = датаОткр;
    }

    @Basic
    @Column(name = "ДатаЗакр", nullable = true)
    public Timestamp getДатаЗакр() {
        return датаЗакр;
    }

    public void setДатаЗакр(Timestamp датаЗакр) {
        this.датаЗакр = датаЗакр;
    }

    @Basic
    @Column(name = "КолЧел", nullable = true)
    public Short getКолЧел() {
        return колЧел;
    }

    public void setКолЧел(Short колЧел) {
        this.колЧел = колЧел;
    }

    @Basic
    @Column(name = "Шкала", nullable = true)
    public Boolean getШкала() {
        return шкала;
    }

    public void setШкала(Boolean шкала) {
        this.шкала = шкала;
    }

    @Basic
    @Column(name = "ПрЭксп", nullable = true)
    public Boolean getПрЭксп() {
        return прЭксп;
    }

    public void setПрЭксп(Boolean прЭксп) {
        this.прЭксп = прЭксп;
    }

    @Basic
    @Column(name = "Примеч", nullable = true, length = 255)
    public String getПримеч() {
        return примеч;
    }

    public void setПримеч(String примеч) {
        this.примеч = примеч;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupsEntity that = (GroupsEntity) o;

        if (id != that.id) return false;
        if (сокрНг != null ? !сокрНг.equals(that.сокрНг) : that.сокрНг != null) return false;
        if (кодПрогр != null ? !кодПрогр.equals(that.кодПрогр) : that.кодПрогр != null) return false;
        if (кодМет != null ? !кодМет.equals(that.кодМет) : that.кодМет != null) return false;
        if (расшПрог != null ? !расшПрог.equals(that.расшПрог) : that.расшПрог != null) return false;
        if (профПрог != null ? !профПрог.equals(that.профПрог) : that.профПрог != null) return false;
        if (датаОткр != null ? !датаОткр.equals(that.датаОткр) : that.датаОткр != null) return false;
        if (датаЗакр != null ? !датаЗакр.equals(that.датаЗакр) : that.датаЗакр != null) return false;
        if (колЧел != null ? !колЧел.equals(that.колЧел) : that.колЧел != null) return false;
        if (шкала != null ? !шкала.equals(that.шкала) : that.шкала != null) return false;
        if (прЭксп != null ? !прЭксп.equals(that.прЭксп) : that.прЭксп != null) return false;
        if (примеч != null ? !примеч.equals(that.примеч) : that.примеч != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (сокрНг != null ? сокрНг.hashCode() : 0);
        result = 31 * result + (кодПрогр != null ? кодПрогр.hashCode() : 0);
        result = 31 * result + (кодМет != null ? кодМет.hashCode() : 0);
        result = 31 * result + (расшПрог != null ? расшПрог.hashCode() : 0);
        result = 31 * result + (профПрог != null ? профПрог.hashCode() : 0);
        result = 31 * result + (датаОткр != null ? датаОткр.hashCode() : 0);
        result = 31 * result + (датаЗакр != null ? датаЗакр.hashCode() : 0);
        result = 31 * result + (колЧел != null ? колЧел.hashCode() : 0);
        result = 31 * result + (шкала != null ? шкала.hashCode() : 0);
        result = 31 * result + (прЭксп != null ? прЭксп.hashCode() : 0);
        result = 31 * result + (примеч != null ? примеч.hashCode() : 0);
        return result;
    }

    private int sem=0;
    @Transient
    public int getCurrSem()
    {

        if (sem==0) {
            Date date1 = new Date(this.getДатаОткр().getTime());
            int month = date1.getMonth();
            int year = date1.getYear();
            Date currDate = new Date(System.currentTimeMillis());
            if (month == 1) {
                if (currDate.getMonth() < 8)
                    sem = (currDate.getYear() - year) * 2 + 1;
                else
                    sem = (currDate.getYear() - year + 1) * 2;
            } else {
                if (currDate.getMonth() > 7)
                    sem = (currDate.getYear() - year) * 2 + 1;
                else
                    sem = (currDate.getYear() - year) * 2;
            }
        }

        return sem;
    }
    private String currName =null;
    @Transient
    public String getCurrName()
    {
        if (currName==null)
        {
            currName="";
            if (расшПрог!=null)
                currName = расшПрог;
            currName+=getCurrSem()+сокрНг;
            if (профПрог!=null)
                currName+=профПрог;

        }
        return currName;
    }

    private Collection<RaspEntity> raspList;

    @OneToMany(mappedBy = "кодГруп",fetch = FetchType.LAZY,orphanRemoval = true)
    public Collection<RaspEntity> getRaspList() {
        return raspList;
    }

    public void setRaspList(Collection<RaspEntity> raspList) {
        this.raspList = raspList;
    }
}
