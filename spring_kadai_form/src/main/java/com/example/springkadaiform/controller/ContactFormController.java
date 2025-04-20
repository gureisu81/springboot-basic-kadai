package com.example.springkadaiform.controller;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springkadaiform.form.ContactForm;

@Controller
public class ContactFormController {

    @GetMapping("/form")
    public String showForm(ContactForm contactForm) {
        return "contactFormView";
    }

    @PostMapping("/confirm")
    public String confirm(@Valid @ModelAttribute ContactForm contactForm,
                          BindingResult bindingResult,
                          Model model) {
        if (bindingResult.hasErrors()) {
            return "contactFormView"; // バリデーションNGでフォームへ戻る
        }
        return "confirmView"; // バリデーションOKで確認画面へ
    }
}
