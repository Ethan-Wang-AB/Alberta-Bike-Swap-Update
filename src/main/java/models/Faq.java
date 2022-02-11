/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 845593
 */
@Entity
@Table(name = "faq")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Faq.findAll", query = "SELECT f FROM Faq f")
    , @NamedQuery(name = "Faq.findByFaqId", query = "SELECT f FROM Faq f WHERE f.faqId = :faqId")
    , @NamedQuery(name = "Faq.findByFaqTitle", query = "SELECT f FROM Faq f WHERE f.faqTitle = :faqTitle")
    , @NamedQuery(name = "Faq.findByFaqQuestion", query = "SELECT f FROM Faq f WHERE f.faqQuestion = :faqQuestion")
    , @NamedQuery(name = "Faq.findByFaqAnswer", query = "SELECT f FROM Faq f WHERE f.faqAnswer = :faqAnswer")
    , @NamedQuery(name = "Faq.findByFaqVisible", query = "SELECT f FROM Faq f WHERE f.faqVisible = :faqVisible")
    , @NamedQuery(name = "Faq.findByType", query = "SELECT f FROM Faq f WHERE f.type = :type")
    , @NamedQuery(name = "Faq.findByPosition", query = "SELECT f FROM Faq f WHERE f.position = :position")})
public class Faq implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "faq_id")
    private Integer faqId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "faq_title")
    private String faqTitle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "faq_question")
    private String faqQuestion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "faq_answer")
    private String faqAnswer;
    @Basic(optional = false)
    @NotNull
    @Column(name = "faq_visible")
    private boolean faqVisible;
    @Basic(optional = false)
    @NotNull
    @Column(name = "type")
    private boolean type;
    @Column(name = "position")
    private Integer position;

    public Faq() {
    }

    public Faq(Integer faqId) {
        this.faqId = faqId;
    }

    public Faq(Integer faqId, String faqTitle, String faqQuestion, String faqAnswer, boolean faqVisible, boolean type) {
        this.faqId = faqId;
        this.faqTitle = faqTitle;
        this.faqQuestion = faqQuestion;
        this.faqAnswer = faqAnswer;
        this.faqVisible = faqVisible;
        this.type = type;
    }

    public Integer getFaqId() {
        return faqId;
    }

    public void setFaqId(Integer faqId) {
        this.faqId = faqId;
    }

    public String getFaqTitle() {
        return faqTitle;
    }

    public void setFaqTitle(String faqTitle) {
        this.faqTitle = faqTitle;
    }

    public String getFaqQuestion() {
        return faqQuestion;
    }

    public void setFaqQuestion(String faqQuestion) {
        this.faqQuestion = faqQuestion;
    }

    public String getFaqAnswer() {
        return faqAnswer;
    }

    public void setFaqAnswer(String faqAnswer) {
        this.faqAnswer = faqAnswer;
    }

    public boolean getFaqVisible() {
        return faqVisible;
    }

    public void setFaqVisible(boolean faqVisible) {
        this.faqVisible = faqVisible;
    }

    public boolean getType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (faqId != null ? faqId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Faq)) {
            return false;
        }
        Faq other = (Faq) object;
        if ((this.faqId == null && other.faqId != null) || (this.faqId != null && !this.faqId.equals(other.faqId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Faq[ faqId=" + faqId + " ]";
    }
    
}
