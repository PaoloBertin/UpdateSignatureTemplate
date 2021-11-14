package eu.opensource.updateSignatureTemplate.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Table(name = "tp_signature_template")
@Entity
public class TpSignatureTemplate implements Serializable {

    private static final long serialVersionUID = 7094776511733721742L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tp_signature_template_name")
    private String tpSignatureTemplateName;

    @OneToMany(mappedBy = "tpSignatureTemplate", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SignatureTemplate> signaturaTemplateSet;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getTpSignatureTemplateName() {

        return tpSignatureTemplateName;
    }

    public void setTpSignatureTemplateName(String tpSignatureTemplateName) {

        this.tpSignatureTemplateName = tpSignatureTemplateName;
    }

    public Set<SignatureTemplate> getSignaturaTemplateSet() {

        return signaturaTemplateSet;
    }

    public void setSignaturaTemplateSet(Set<SignatureTemplate> signaturaTemplateSet) {

        this.signaturaTemplateSet = signaturaTemplateSet;
    }
}
