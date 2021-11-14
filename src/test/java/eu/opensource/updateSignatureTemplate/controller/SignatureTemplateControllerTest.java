package eu.opensource.updateSignatureTemplate.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import eu.opensource.updateSignatureTemplate.controller.util.SignatureTemplateRequest;
import eu.opensource.updateSignatureTemplate.domain.DocumentClassFolder;
import eu.opensource.updateSignatureTemplate.domain.SignatureTemplate;
import eu.opensource.updateSignatureTemplate.domain.TpSignatureTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

//@AutoConfigureMockMvc
//@SpringBootTest
class SignatureTemplateControllerTest {

    @Autowired
    private MockMvc mvc;

    private String sql = "/signatureTemplate";

//    @Test
    void createSignatureTemplate() throws Exception {

        DocumentClassFolder documentClassFolder = new DocumentClassFolder();
        TpSignatureTemplate tpSignatureTemplate = new TpSignatureTemplate();

        SignatureTemplate signatureTemplate = new SignatureTemplate();

        signatureTemplate.setSignaturaTemplateName("RD_RegistroProtocolloInformatico10");

        SignatureTemplateRequest signatureTemplateRequest = new SignatureTemplateRequest();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
//        String requestJson = objectMapper.writeValueAsString(product);

//        mvc.perform(put("/api/products/{id}", 1L).contentType(MediaType.APPLICATION_JSON)
//                                                 .content(requestJson))
//           .andExpect(jsonPath("$.name", equalTo("Da Basic a Java")))
//           .andExpect(status().isOk());


//        mvc.perform(get(sql).contentType(MediaType.APPLICATION_JSON).content(requestJson))
//           .andExpect();
    }

//    @Test
    void getSignatureTemplate() {

    }

//    @Test
    void getAllSignatureTemplate() {

    }

//    @Test
    void updateSignatureTemplate() {

    }

//    @Test
    void deleteSignatureTemplate() {

    }

//    @Test
    void setIsDefault() {

    }
}