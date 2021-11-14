package eu.opensource.updateSignatureTemplate.service;

import eu.opensource.updateSignatureTemplate.controller.util.SignatureTemplateRequest;
import eu.opensource.updateSignatureTemplate.controller.util.SignatureTemplateResponse;

public interface SignatureTemplateService {

    SignatureTemplateResponse getSignatureTemplate(SignatureTemplateRequest request);

    SignatureTemplateResponse getAllSignatureTemplates(SignatureTemplateRequest request);

    SignatureTemplateResponse createSignateTemplate(SignatureTemplateRequest request);

    SignatureTemplateResponse updateSignatureTemplate(SignatureTemplateRequest request);

    SignatureTemplateResponse deleteSignatureTemplate(SignatureTemplateRequest request);

    SignatureTemplateResponse changeDefaultSignatureTemplate(SignatureTemplateRequest request);

}
