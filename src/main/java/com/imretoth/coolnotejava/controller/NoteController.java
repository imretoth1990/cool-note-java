package com.imretoth.coolnotejava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class NoteController {
    static String note;
    static int editCount = 0;
    @GetMapping
    public String index(Model model) {
        model.addAttribute("note", note);
        model.addAttribute( "editCount", editCount );
        return "index";
    }
    @GetMapping("note")
    public String displayAddNoteForm(Model model) {
        model.addAttribute("title", editCount == 0 ? "Add Note" : "Edit Note");
        model.addAttribute("note", note);
        ++editCount;

        return "note";
    }

    @PostMapping("note")
    public String processAddNoteForm(@RequestParam String newNote) {
        note = newNote;
        return "redirect:";
    }

}
