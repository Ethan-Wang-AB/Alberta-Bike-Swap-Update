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
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
    , @NamedQuery(name = "User.findByUserId", query = "SELECT u FROM User u WHERE u.userId = :userId")
    , @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email")
    , @NamedQuery(name = "User.findByName", query = "SELECT u FROM User u WHERE u.name = :name")
    , @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password")
    , @NamedQuery(name = "User.findBySalt", query = "SELECT u FROM User u WHERE u.salt = :salt")
    , @NamedQuery(name = "User.findByResetPasswordUuid", query = "SELECT u FROM User u WHERE u.resetPasswordUuid = :resetPasswordUuid")
    , @NamedQuery(name = "User.findByPhotoPath", query = "SELECT u FROM User u WHERE u.photoPath = :photoPath")
    , @NamedQuery(name = "User.findByCellNumber", query = "SELECT u FROM User u WHERE u.cellNumber = :cellNumber")
    , @NamedQuery(name = "User.findByShirtSize", query = "SELECT u FROM User u WHERE u.shirtSize = :shirtSize")
    , @NamedQuery(name = "User.findByTicket", query = "SELECT u FROM User u WHERE u.ticket = :ticket")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "password")
    private String password;
    @Size(max = 100)
    @Column(name = "salt")
    private String salt;
    @Size(max = 50)
    @Column(name = "reset_password_uuid")
    private String resetPasswordUuid;
    @Size(max = 300)
    @Column(name = "photoPath")
    private String photoPath;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cell_number")
    private long cellNumber;
    @Column(name = "shirt_size")
    private Short shirtSize;
    @Column(name = "ticket")
    private Integer ticket;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<EventDateUser> eventDateUserList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<Bike> bikeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "buyerId")
    private List<Trade> tradeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sellerId")
    private List<Trade> tradeList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<TradeOthers> tradeOthersList;
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    @ManyToOne
    private Address addressId;
    @JoinColumn(name = "affiliation_id", referencedColumnName = "affiliation_id")
    @ManyToOne
    private Affiliation affiliationId;
    @JoinColumn(name = "diet_id", referencedColumnName = "diet_id")
    @ManyToOne
    private Diet dietId;
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    @ManyToOne
    private Role roleId;
    @JoinColumn(name = "role_id_first", referencedColumnName = "role_id")
    @ManyToOne
    private Role roleIdFirst;
    @JoinColumn(name = "role_id_second", referencedColumnName = "role_id")
    @ManyToOne
    private Role roleIdSecond;

    public User() {
    }

    public User(Integer userId) {
        this.userId = userId;
    }

    public User(Integer userId, String email, String name, String password, long cellNumber) {
        this.userId = userId;
        this.email = email;
        this.name = name;
        this.password = password;
        this.cellNumber = cellNumber;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getResetPasswordUuid() {
        return resetPasswordUuid;
    }

    public void setResetPasswordUuid(String resetPasswordUuid) {
        this.resetPasswordUuid = resetPasswordUuid;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public long getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(long cellNumber) {
        this.cellNumber = cellNumber;
    }

    public Short getShirtSize() {
        return shirtSize;
    }

    public void setShirtSize(Short shirtSize) {
        this.shirtSize = shirtSize;
    }

    public Integer getTicket() {
        return ticket;
    }

    public void setTicket(Integer ticket) {
        this.ticket = ticket;
    }

    @XmlTransient
    public List<EventDateUser> getEventDateUserList() {
        return eventDateUserList;
    }

    public void setEventDateUserList(List<EventDateUser> eventDateUserList) {
        this.eventDateUserList = eventDateUserList;
    }

    @XmlTransient
    public List<Bike> getBikeList() {
        return bikeList;
    }

    public void setBikeList(List<Bike> bikeList) {
        this.bikeList = bikeList;
    }

    @XmlTransient
    public List<Trade> getTradeList() {
        return tradeList;
    }

    public void setTradeList(List<Trade> tradeList) {
        this.tradeList = tradeList;
    }

    @XmlTransient
    public List<Trade> getTradeList1() {
        return tradeList1;
    }

    public void setTradeList1(List<Trade> tradeList1) {
        this.tradeList1 = tradeList1;
    }

    @XmlTransient
    public List<TradeOthers> getTradeOthersList() {
        return tradeOthersList;
    }

    public void setTradeOthersList(List<TradeOthers> tradeOthersList) {
        this.tradeOthersList = tradeOthersList;
    }

    public Address getAddressId() {
        return addressId;
    }

    public void setAddressId(Address addressId) {
        this.addressId = addressId;
    }

    public Affiliation getAffiliationId() {
        return affiliationId;
    }

    public void setAffiliationId(Affiliation affiliationId) {
        this.affiliationId = affiliationId;
    }

    public Diet getDietId() {
        return dietId;
    }

    public void setDietId(Diet dietId) {
        this.dietId = dietId;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    public Role getRoleIdFirst() {
        return roleIdFirst;
    }

    public void setRoleIdFirst(Role roleIdFirst) {
        this.roleIdFirst = roleIdFirst;
    }

    public Role getRoleIdSecond() {
        return roleIdSecond;
    }

    public void setRoleIdSecond(Role roleIdSecond) {
        this.roleIdSecond = roleIdSecond;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.User[ userId=" + userId + " ]";
    }
    
}
