package vn.codegym.validation.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.validation.dto.SongDto;
import vn.codegym.validation.model.Song;
import vn.codegym.validation.service.ISongService;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    ISongService iSongService;

    @GetMapping
    public String showForm(@PageableDefault(value = 3) Pageable pageable, Model model) {
        Page<Song> page = iSongService.findAll(pageable);
        model.addAttribute("song", page);
        return "/home";
    }

    @GetMapping("/create")
    public String showCrate(Model model) {
        model.addAttribute("songDto", new SongDto());
        return "/form";
    }

    @PostMapping("/save")
    public String createUser(@Validated @ModelAttribute SongDto songDto,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes,
                             Model model) {
        new SongDto().validate(songDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "/form";
        } else {
            Song song = new Song();
            BeanUtils.copyProperties(songDto, song);
            iSongService.create(song);
            redirectAttributes.addFlashAttribute("message", "Create success!!");
        }
        return "redirect:/song";
    }

    @GetMapping("{id}/edit")
    public String showUpdateForm(@PathVariable int id, Model model) {
        Song song = iSongService.findById(id);
        model.addAttribute("song", song );
        return ("edit");
    }

    @PostMapping("/update")
    public String update(@Validated @ModelAttribute("song") SongDto songDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,
                         Model model) {
        new SongDto().validate(songDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {

            return ("edit");
        } else {
            Song song = new Song();
            BeanUtils.copyProperties(songDto, song);
            iSongService.create(song);
            redirectAttributes.addFlashAttribute("message", "Update success!!");
        }
        return ("redirect:/song");
    }
}
