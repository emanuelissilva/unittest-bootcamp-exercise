package com.digitalhouse.obtenerdiploma;

import com.digitalhouse.obtenerdiploma.dto.CertificateDTO;
import com.digitalhouse.obtenerdiploma.dto.StudentDTO;
import com.digitalhouse.obtenerdiploma.dto.SubjectDTO;
import com.digitalhouse.obtenerdiploma.service.CertificateServiceImpl;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CertificateServiceImplTest {

    private CertificateServiceImpl certificateService = new CertificateServiceImpl();

    @Test
    public void analizeNotes() throws Exception{
        SubjectDTO subject1 = new SubjectDTO("math", 8);
        SubjectDTO subject2 = new SubjectDTO("history", 6);
        SubjectDTO subject3 = new SubjectDTO("biology", 10);
        List<SubjectDTO> list = new ArrayList<>();
        list.add(subject1);
        list.add(subject2);
        list.add(subject3);
        StudentDTO teste = new StudentDTO("Maria Fernandez", list);

        CertificateDTO response = certificateService.analyzeNotes(teste);

        assertEquals(response.getAverage(), 8);
    }

    @Test
    public void analizeNotesNot() throws Exception{
        SubjectDTO subject1 = new SubjectDTO("math", 8);
        SubjectDTO subject2 = new SubjectDTO("history", 6);
        SubjectDTO subject3 = new SubjectDTO("biology", 10);
        List<SubjectDTO> list = new ArrayList<>();
        list.add(subject1);
        list.add(subject2);
        list.add(subject3);
        StudentDTO teste = new StudentDTO("Maria Fernandez", list);

        CertificateDTO response = certificateService.analyzeNotes(teste);

        assertNotEquals(response.getAverage(), 5);
    }

    @Test
    public void calculateAverage() throws Exception{
        SubjectDTO subject1 = new SubjectDTO("math", 8);
        SubjectDTO subject2 = new SubjectDTO("history", 6);
        SubjectDTO subject3 = new SubjectDTO("biology", 10);
        List<SubjectDTO> list = new ArrayList<>();
        list.add(subject1);
        list.add(subject2);
        list.add(subject3);
        StudentDTO teste = new StudentDTO("Maria Fernandez", list);
        CertificateDTO certificate = new CertificateDTO(teste);

        Double response = certificateService.calculateAverage(teste);

        assertEquals(response, 8);
    }


    @Test
    public void calculateAverageNot() throws Exception{
        SubjectDTO subject1 = new SubjectDTO("math", 8);
        SubjectDTO subject2 = new SubjectDTO("history", 6);
        SubjectDTO subject3 = new SubjectDTO("biology", 10);
        List<SubjectDTO> list = new ArrayList<>();
        list.add(subject1);
        list.add(subject2);
        list.add(subject3);
        StudentDTO teste = new StudentDTO("Maria Fernandez", list);
        CertificateDTO certificate = new CertificateDTO(teste);

        Double response = certificateService.calculateAverage(teste);

        assertNotEquals(response, 3);
    }

    @Test
    public void writeDiploma() throws Exception{
        SubjectDTO subject1 = new SubjectDTO("math", 8);
        SubjectDTO subject2 = new SubjectDTO("history", 6);
        SubjectDTO subject3 = new SubjectDTO("biology", 10);
        List<SubjectDTO> list = new ArrayList<>();
        list.add(subject1);
        list.add(subject2);
        list.add(subject3);
        StudentDTO teste = new StudentDTO("Maria Fernandez", list);
        CertificateDTO certificate = new CertificateDTO(teste);

        String response = certificateService.writeDiploma(teste);

        assertEquals(response, "Maria Fernandez usted ha conseguido el promedio de 8.0");
    }

    @Test
    public void writeDiplomaNot() throws Exception{
        SubjectDTO subject1 = new SubjectDTO("math", 8);
        SubjectDTO subject2 = new SubjectDTO("history", 6);
        SubjectDTO subject3 = new SubjectDTO("biology", 10);
        List<SubjectDTO> list = new ArrayList<>();
        list.add(subject1);
        list.add(subject2);
        list.add(subject3);
        StudentDTO teste = new StudentDTO("Maria Fernandez", list);
        CertificateDTO certificate = new CertificateDTO(teste);

        String response = certificateService.writeDiploma(teste);

        assertNotEquals(response, "Maria Fernandez usted ha conseguido el promedio de 9.0");
    }

    @Test
    public void withHonors() throws Exception{
        SubjectDTO subject1 = new SubjectDTO("math", 8);
        SubjectDTO subject2 = new SubjectDTO("history", 6);
        SubjectDTO subject3 = new SubjectDTO("biology", 10);
        List<SubjectDTO> list = new ArrayList<>();
        list.add(subject1);
        list.add(subject2);
        list.add(subject3);
        StudentDTO teste = new StudentDTO("Maria Fernandez", list);
        CertificateDTO certificate = new CertificateDTO(teste);

        String response = certificateService.withHonors(certificate.getAverage(), teste.getName());

        assertEquals(response, "¡Felicitaciones Maria Fernandez! usted ha conseguido el promedio de 8.0");
    }

    @Test
    public void withHonorsNot() throws Exception{
        SubjectDTO subject1 = new SubjectDTO("math", 8);
        SubjectDTO subject2 = new SubjectDTO("history", 6);
        SubjectDTO subject3 = new SubjectDTO("biology", 10);
        List<SubjectDTO> list = new ArrayList<>();
        list.add(subject1);
        list.add(subject2);
        list.add(subject3);
        StudentDTO teste = new StudentDTO("Maria Fernandez", list);
        CertificateDTO certificate = new CertificateDTO(teste);

        String response = certificateService.withHonors(certificate.getAverage(), teste.getName());

        assertNotEquals(response, "¡Felicitaciones Maria Fernandez! usted ha conseguido el promedio de 3.0");
    }
}
