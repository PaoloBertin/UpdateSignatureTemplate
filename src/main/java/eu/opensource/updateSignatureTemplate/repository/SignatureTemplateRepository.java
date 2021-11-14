package eu.opensource.updateSignatureTemplate.repository;

import eu.opensource.updateSignatureTemplate.domain.SignatureTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SignatureTemplateRepository extends JpaRepository<SignatureTemplate, Long> {

    //    @Query("UPDATE SignatureTemplate ST SET ST.isDefault = CASE WHEN ST.id = :defaultSignatureTemplateId THEN true ELSE false END WHERE ST.id IN (SELECT ST.id FROM SignatureTemplate ST JOIN ST.documentClassFolder D WHERE D.id = (SELECT D.id FROM SignatureTemplate ST JOIN ST.documentClassFolder D WHERE ST.id = :defaultSignatureTemplateId)")
    @Modifying
    @Query("UPDATE SignatureTemplate ST SET ST.isDefault = CASE WHEN ST.id = :defaultSignatureTemplateId " +
           "                                                        THEN true " +
           "                                                        ELSE false " +
           "                                               END " +
           "WHERE ST.id IN (" +
           "                 SELECT ST.id " +
           "                 FROM SignatureTemplate ST " +
           "                 JOIN ST.documentClassFolder D " +
           "                 WHERE D.id = (" +
           "                                SELECT D.id " +
           "                                FROM SignatureTemplate ST " +
           "                                JOIN ST.documentClassFolder D " +
           "                                WHERE ST.id = :defaultSignatureTemplateId" +
           "                              )" +
           "               )" +
//           "AND ST.id IN (" +
//           "                " +
           "             )")
    int setDefaultForDocumentClass(@Param("defaultSignatureTemplateId") Long defaultSignatureTemplateId);
}
