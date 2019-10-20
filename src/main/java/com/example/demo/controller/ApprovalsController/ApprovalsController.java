package com.example.demo.controller.ApprovalsController;

import com.example.demo.domain.Approvals.Approvals;
import com.example.demo.factory.ApprovalsFactory.ApprovalsFactory;
import com.example.demo.service.ApprovalsService.impl.ApprovalsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/approvals")
public class ApprovalsController {

    @Autowired
    ApprovalsServiceImpl approvalsService;

    @RequestMapping(value = "/create/{date}/{details}", method = RequestMethod.POST)
    public @ResponseBody Approvals create(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd") Date date, @PathVariable String details)
            //public @ResponseBody Approvals create(@PathVariable Date date, @PathVariable String details)
    {
        return this.approvalsService.create(ApprovalsFactory.getApproval(date, details));
    }

    @GetMapping(value = "/read/{a}")
    public @ResponseBody Approvals read(@PathVariable Integer a)
    {
        return this.approvalsService.read(a);
    }

    @PutMapping(value = "/update/{x}/{date}/{details}")
    public @ResponseBody Approvals update(@PathVariable Integer x, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd") Date date, @PathVariable String details)
    {
        return this.approvalsService.update(ApprovalsFactory.updateApproval(x, date, details));
    }

    @DeleteMapping(value = "/delete/{i}")
    public void delete(@PathVariable Integer i)
    {
        this.approvalsService.delete(i);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public @ResponseBody
    List<Approvals> getAll()
    {
        return this.approvalsService.getAll();
    }
}
