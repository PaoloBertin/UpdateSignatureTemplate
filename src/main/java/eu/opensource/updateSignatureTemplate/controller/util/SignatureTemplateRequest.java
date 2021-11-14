package eu.opensource.updateSignatureTemplate.controller.util;

public class SignatureTemplateRequest {

    private SignatureTemplatePayload signatureTemplatePayload;

/*
    private SignatureTemplateHeader signatureTemplateHeader;


    public SignatureTemplateHeader getSignatureTemplateHeader() {

        return signatureTemplateHeader;
    }

    public void setSignatureTemplateHeader(SignatureTemplateHeader signatureTemplateHeader) {

        this.signatureTemplateHeader = signatureTemplateHeader;
    }

 */

    public SignatureTemplatePayload getSignatureTemplatePayload() {

        return signatureTemplatePayload;
    }

    public void setSignatureTemplatePayload(SignatureTemplatePayload signatureTemplatePayload) {

        this.signatureTemplatePayload = signatureTemplatePayload;
    }

}
