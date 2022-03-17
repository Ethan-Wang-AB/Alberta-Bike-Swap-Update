/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 845593
 */
@Entity
@Table(name = "bike")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bike.findAll", query = "SELECT b FROM Bike b")
    , @NamedQuery(name = "Bike.findByBikeId", query = "SELECT b FROM Bike b WHERE b.bikeId = :bikeId")
    , @NamedQuery(name = "Bike.findByBikeIndex", query = "SELECT b FROM Bike b WHERE b.bikeIndex = :bikeIndex")
    , @NamedQuery(name = "Bike.findByPhotoPath", query = "SELECT b FROM Bike b WHERE b.photoPath = :photoPath")
    , @NamedQuery(name = "Bike.findByMaker", query = "SELECT b FROM Bike b WHERE b.maker = :maker")
    , @NamedQuery(name = "Bike.findByModel", query = "SELECT b FROM Bike b WHERE b.model = :model")
    , @NamedQuery(name = "Bike.findBySize", query = "SELECT b FROM Bike b WHERE b.size = :size")
    , @NamedQuery(name = "Bike.findByPrice", query = "SELECT b FROM Bike b WHERE b.price = :price")
    , @NamedQuery(name = "Bike.findByToSell", query = "SELECT b FROM Bike b WHERE b.toSell = :toSell")
    , @NamedQuery(name = "Bike.findByDonate", query = "SELECT b FROM Bike b WHERE b.donate = :donate")
    , @NamedQuery(name = "Bike.findByBikeEventTickets", query = "SELECT b FROM Bike b WHERE b.bikeEventTickets = :bikeEventTickets")
    , @NamedQuery(name = "Bike.findByChecked", query = "SELECT b FROM Bike b WHERE b.checked = :checked")})
public class Bike implements Serializable {

    @Lob
    @Column(name = "photo")
    private byte[] photo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bikeId")
    private List<Trade> tradeList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bike_id")
    private Integer bikeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "bike_index")
    private String bikeIndex;
    @Size(max = 200)
    @Column(name = "photo_path")
    private String photoPath;
    @Size(max = 20)
    @Column(name = "maker")
    private String maker;
    @Size(max = 20)
    @Column(name = "model")
    private String model;
    @Column(name = "size")
    private Boolean size;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private double price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "toSell")
    private boolean toSell;
    @Basic(optional = false)
    @NotNull
    @Column(name = "donate")
    private boolean donate;
    @Size(max = 30)
    @Column(name = "bike_event_tickets")
    private String bikeEventTickets;
    @Column(name = "checked")
    private Boolean checked;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User userId;

    public Bike() {
    }

    public Bike(Integer bikeId) {
        this.bikeId = bikeId;
    }

    public Bike(Integer bikeId, String bikeIndex, double price, boolean toSell, boolean donate) {
        this.bikeId = bikeId;
        this.bikeIndex = bikeIndex;
        this.price = price;
        this.toSell = toSell;
        this.donate = donate;
    }

    public Integer getBikeId() {
        return bikeId;
    }

    public void setBikeId(Integer bikeId) {
        this.bikeId = bikeId;
    }

    public String getBikeIndex() {
        return bikeIndex;
    }

    public void setBikeIndex(String bikeIndex) {
        this.bikeIndex = bikeIndex;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Boolean getSize() {
        return size;
    }

    public void setSize(Boolean size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean getToSell() {
        return toSell;
    }

    public void setToSell(boolean toSell) {
        this.toSell = toSell;
    }

    public boolean getDonate() {
        return donate;
    }

    public void setDonate(boolean donate) {
        this.donate = donate;
    }

    public String getBikeEventTickets() {
        return bikeEventTickets;
    }

    public void setBikeEventTickets(String bikeEventTickets) {
        this.bikeEventTickets = bikeEventTickets;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bikeId != null ? bikeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bike)) {
            return false;
        }
        Bike other = (Bike) object;
        if ((this.bikeId == null && other.bikeId != null) || (this.bikeId != null && !this.bikeId.equals(other.bikeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Bike[ bikeId=" + bikeId + " ]";
    }

    @XmlTransient
    public List<Trade> getTradeList() {
        return tradeList;
    }

    public void setTradeList(List<Trade> tradeList) {
        this.tradeList = tradeList;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
    
}
