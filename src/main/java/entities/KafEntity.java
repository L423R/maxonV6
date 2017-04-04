package entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Maxon on 23.02.2017.
 */
@Entity
@Table(name = "kaf", schema = "maxdip", catalog = "")
public class KafEntity {
    private int кодКаф;
    private String наимКаф;
    private Short рангКаф;
    private String контКаф;

    @Id
    @Column(name = "КодКаф", nullable = false)
    public int getКодКаф() {
        return кодКаф;
    }

    public void setКодКаф(int кодКаф) {
        this.кодКаф = кодКаф;
    }

    @Basic
    @Column(name = "НаимКаф", nullable = true, length = 70)
    public String getНаимКаф() {
        return наимКаф;
    }

    public void setНаимКаф(String наимКаф) {
        this.наимКаф = наимКаф;
    }

    @Basic
    @Column(name = "РангКаф", nullable = true)
    public Short getРангКаф() {
        return рангКаф;
    }

    public void setРангКаф(Short рангКаф) {
        this.рангКаф = рангКаф;
    }

    @Basic
    @Column(name = "Конт_Каф", nullable = true, length = 255)
    public String getКонтКаф() {
        return контКаф;
    }

    public void setКонтКаф(String контКаф) {
        this.контКаф = контКаф;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KafEntity entity = (KafEntity) o;

        if (кодКаф != entity.кодКаф) return false;
        if (наимКаф != null ? !наимКаф.equals(entity.наимКаф) : entity.наимКаф != null) return false;
        if (рангКаф != null ? !рангКаф.equals(entity.рангКаф) : entity.рангКаф != null) return false;
        if (контКаф != null ? !контКаф.equals(entity.контКаф) : entity.контКаф != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = кодКаф;
        result = 31 * result + (наимКаф != null ? наимКаф.hashCode() : 0);
        result = 31 * result + (рангКаф != null ? рангКаф.hashCode() : 0);
        result = 31 * result + (контКаф != null ? контКаф.hashCode() : 0);
        return result;
    }

    private Collection<DiscEntity> discList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "кодКаф")
    public Collection<DiscEntity> getDiscList() {
        return discList;
    }

    public void setDiscList(Collection<DiscEntity> discList) {
        this.discList = discList;
    }

    private Collection<PrepsEntity> PrepsList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "кодКаф",fetch = FetchType.EAGER)
    public Collection<PrepsEntity> getPrepsList() {
        return PrepsList;
    }

    public void setPrepsList(Collection<PrepsEntity> prepsList) {
        PrepsList = prepsList;
    }
}
