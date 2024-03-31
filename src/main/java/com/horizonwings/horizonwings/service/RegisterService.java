package com.horizonwings.horizonwings.service;

//import com.horizonwings.horizonwings.entity.Student;
import com.horizonwings.horizonwings.model.Gender;
import com.horizonwings.horizonwings.model.PreviouEducation;
import com.horizonwings.horizonwings.model.RegisterModel;
//import com.horizonwings.horizonwings.repository.RegisterRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
@Slf4j
public class RegisterService {

//    @Autowired
//    RegisterRepository registerRepository;

    @Autowired
    private JavaMailSender javaMailSender;


    public String registerStudent(RegisterModel  registerModel){
        try {
//        Student student=new Student(
//                registerModel.getName(),
//                registerModel.getEmailId(),
//                registerModel.getMobile(),
//                registerModel.getCountryCode(),
//                Gender.valueOf(registerModel.getGender().isEmpty()?"MALE":registerModel.getGender()),
//                PreviouEducation.valueOf(registerModel.getPreviousEducation().isEmpty()?"HIGH_SCHOOL":registerModel.getPreviousEducation())
//        );
//        registerRepository.save(student);
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());
//        helper.setTo("apoorv.dixit.developer@gmail.com");
            helper.setFrom("info.horizonwings@gmail.com");
            String[] emailsToSend={"hitesh.horizonwings@gmail.com",registerModel.getEmailId()};
            helper.setTo(emailsToSend);
            helper.setSubject("Confirmation of Registration - HorizonWings Overseas Education");
            String gender=registerModel.getGender()==null?"NA":registerModel.getGender();
            String prevEdu=registerModel.getPreviousEducation()==null?"NA":registerModel.getPreviousEducation();
            String text="Dear "+registerModel.getName()+",\n" +
                    "\n" +
                    "We hope this email finds you well and full of excitement for the journey ahead!\n" +
                    "\n" +
                    "We are thrilled to confirm that we have successfully received your registration details for our esteemed institution, HorizonWings Overseas Education. Your dedication to pursuing higher education abroad is truly commendable, and we are here to support you every step of the way.\n" +
                    "\n" +
                    "Below, you will find a summary of the information you provided during registration:\n" +
                    "\n" +
                    "- Name: "+registerModel.getName()+"\n" +
                    "- Email: "+registerModel.getEmailId()+"\n" +
                    "- Gender: "+gender+"\n" +
                    "- Previous Education: "+prevEdu+"\n" +
                    "- Mobile Number: "+registerModel.getCountryCode()+registerModel.getMobile()+"\n" +
                    "\n" +
                    "Please review the details above. If any information is incorrect or incomplete, kindly let us know at your earliest convenience, and we will ensure it is updated accordingly.\n" +
                    "\n" +
                    "At HorizonWings Overseas Education, we are committed to offering you the best guidance and resources to help you achieve your academic and career aspirations. We understand the importance of this decision in shaping your future, and we are honored to be a part of your journey.\n" +
                    "\n" +
                    "Should you have any questions or require further assistance, please do not hesitate to contact us. We are here to assist you in any way we can.\n" +
                    "\n" +
                    "Once again, congratulations on taking this significant step towards your educational goals. We look forward to embarking on this exciting adventure with you!\n" +
                    "\n" +
                    "Warm regards,\n" +
                    "\n" +
                    "Hitesh Chaudhary\n" +
                    "HorizonWings Overseas Education";
            helper.setText(text);
            javaMailSender.send(message);
            log.info(registerModel.toString());
        }
        catch (Exception e){
            log.error(e.getMessage());
        }
        return "Student Registered Successfully";
    }

}
