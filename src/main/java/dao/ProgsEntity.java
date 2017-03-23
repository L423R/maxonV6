package dao;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Maxon on 01.03.2017.
 */
@Entity
@Table(name = "progs", schema = "maxdip", catalog = "")
public class ProgsEntity {
    private int id;
    private NapravlEntity napralv;
    private String наим;
    private String профПрогр;
    private String квалифик;
    private String формаОбуч;
    private String планСрок;
    private String примеч;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "napralv")
    public NapravlEntity getNapralv() {
        return napralv;
    }

    public void setNapralv(NapravlEntity napralv) {
        this.napralv = napralv;
    }

    @Basic
    @Column(name = "Наим", nullable = true, length = 255)
    public String getНаим() {
        return наим;
    }

    public void setНаим(String наим) {
        this.наим = наим;
    }

    @Basic
    @Column(name = "ПрофПрогр", nullable = true, length = 255)
    public String getПрофПрогр() {
        return профПрогр;
    }

    public void setПрофПрогр(String профПрогр) {
        this.профПрогр = профПрогр;
    }

    @Basic
    @Column(name = "Квалифик", nullable = true, length = 255)
    public String getКвалифик() {
        return квалифик;
    }

    public void setКвалифик(String квалифик) {
        this.квалифик = квалифик;
    }

    @Basic
    @Column(name = "ФормаОбуч", nullable = true, length = 255)
    public String getФормаОбуч() {
        return формаОбуч;
    }

    public void setФормаОбуч(String формаОбуч) {
        this.формаОбуч = формаОбуч;
    }

    @Basic
    @Column(name = "ПланСрок", nullable = true, length = 255)
    public String getПланСрок() {
        return планСрок;
    }

    public void setПланСрок(String планСрок) {
        this.планСрок = планСрок;
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

        ProgsEntity that = (ProgsEntity) o;

        if (id != that.id) return false;
        if (napralv != null ? !napralv.equals(that.napralv) : that.napralv != null) return false;
        if (наим != null ? !наим.equals(that.наим) : that.наим != null) return false;
        if (профПрогр != null ? !профПрогр.equals(that.профПрогр) : that.профПрогр != null) return false;
        if (квалифик != null ? !квалифик.equals(that.квалифик) : that.квалифик != null) return false;
        if (формаОбуч != null ? !формаОбуч.equals(that.формаОбуч) : that.формаОбуч != null) return false;
        if (планСрок != null ? !планСрок.equals(that.планСрок) : that.планСрок != null) return false;
        if (примеч != null ? !примеч.equals(that.примеч) : that.примеч != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (napralv != null ? napralv.hashCode() : 0);
        result = 31 * result + (наим != null ? наим.hashCode() : 0);
        result = 31 * result + (профПрогр != null ? профПрогр.hashCode() : 0);
        result = 31 * result + (квалифик != null ? квалифик.hashCode() : 0);
        result = 31 * result + (формаОбуч != null ? формаОбуч.hashCode() : 0);
        result = 31 * result + (планСрок != null ? планСрок.hashCode() : 0);
        result = 31 * result + (примеч != null ? примеч.hashCode() : 0);
        return result;
    }

    private Collection<GroupsEntity> groupList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "кодПрогр",orphanRemoval = true)
    public Collection<GroupsEntity> getGroupList() {
        return groupList;
    }

    public void setGroupList(Collection<GroupsEntity> groupList) {
        this.groupList = groupList;
    }
}
