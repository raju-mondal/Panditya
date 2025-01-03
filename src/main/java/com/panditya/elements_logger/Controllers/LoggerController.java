package com.panditya.elements_logger.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.panditya.elements_logger.Services.LogService;



@RestController
@RequestMapping(produces="application/json")
public class LoggerController {
    
    @Autowired
    private LogService logService ;

    public LoggerController(LogService logService ){
        this.logService=logService;
    }

    @GetMapping("/status")
    public String getStatus() {
        return new String("RAMSITA RAM all ok");
    }

    @GetMapping("/logof/")
    public ResponseEntity<?> getLog(@RequestParam(defaultValue="NA",name="id") String id) {
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(this.logService.getLogById(id));
    }

    @GetMapping("/logof/{service}/")
    public ResponseEntity<?> getLog(@PathVariable String service,@RequestParam(defaultValue="NA") String level,@RequestParam(defaultValue="NA") String lastid) {
        
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(this.logService.getLogByData(service, level, lastid));
    }

    @PostMapping("/log")
    public ResponseEntity<?> postLog(@RequestBody String[] logdto) {

        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(logService.saveLog(logdto));
    }
    
    
    @PostMapping("/logs")
    public ResponseEntity<?> postLogs(@RequestBody String[][] logdtos) {
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(logService.saveLogs(logdtos));
    }
}
