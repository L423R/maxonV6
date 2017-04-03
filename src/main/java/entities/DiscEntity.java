package entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Maxon on 23.02.2017.
 */
@Entity
@Table(name = "disc", schema = "maxdip", catalog = "")
public class DiscEntity {
    private int id;
    private String наимДисц;
    private KafEntity кодКаф;
    private Boolean сдо;
    private Collection<RaspEntity> RaspList;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int кодДисц) {
        this.id = кодДисц;
    }

    @Basic
    @Column(name = "НаимДисц", nullable = true, length = 70)
    public String getНаимДисц() {
        return наимДисц;
    }

    public void setНаимДисц(String наимДисц) {
        this.наимДисц = наимДисц;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "КодКаф")
    public KafEntity getКодКаф() {
        if (кодКаф==null)
        {
            кодКаф = new KafEntity();
            кодКаф.setКодКаф(0);
            кодКаф.setНаимКаф("БЕЗ КАФЕДРЫ");
            кодКаф.setРангКаф((short) 0);
        }
        return кодКаф;
    }

    public void setКодКаф(KafEntity кодКаф) {
        this.кодКаф = кодКаф;
    }

    @Basic
    @Column(name = "СДО", nullable = true)
    public Boolean getСдо() {
        return сдо;
    }

    public void setСдо(Boolean сдо) {
        this.сдо = сдо;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DiscEntity entity = (DiscEntity) o;

        if (id != entity.id) return false;
        if (наимДисц != null ? !наимДисц.equals(entity.наимДисц) : entity.наимДисц != null) return false;
        if (кодКаф != null ? !кодКаф.equals(entity.кодКаф) : entity.кодКаф != null) return false;
        if (сдо != null ? !сдо.equals(entity.сдо) : entity.сдо != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (наимДисц != null ? наимДисц.hashCode() : 0);
        result = 31 * result + (кодКаф != null ? кодКаф.hashCode() : 0);
        result = 31 * result + (сдо != null ? сдо.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "кодДисц")
    public Collection<RaspEntity> getRaspList() {
        return RaspList;
    }

    public void setRaspList(Collection<RaspEntity> raspList) {
        RaspList = raspList;
    }


}
