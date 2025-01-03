package com.panditya.elements_logger.Services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.logging.LogLevel;
import org.springframework.stereotype.Service;

import com.panditya.elements_logger.DTO.LogDTO;
import com.panditya.elements_logger.Entitys.Log;
import com.panditya.elements_logger.Entitys.LogLevels;
import com.panditya.elements_logger.Exceptions.LogFormatNotCorrect;
import com.panditya.elements_logger.Exceptions.LogNotFound;
import com.panditya.elements_logger.Repository.LogRepo;

@Service
public class LogService {
    
    @Value("${CustomConfiguration.ReadCount:3}")
    private final short logLimit=5;

    @Autowired
    private LogRepo logRepository;

    private static Log convertLogFromDTO(String[] data)throws LogFormatNotCorrect{
        //"YY-MM-dd-HH-mm-ss-SSSS"
        String[] dateData = data[1].split("-");
        if(data.length != 5){
            StringBuilder error =new StringBuilder();
            error.append("Log Data Size not correct ");
            error.append(data.length);
            throw new LogFormatNotCorrect(error);
        }
        return new Log(
                        data[0] ,
                        Short.valueOf(dateData[0]),
                        Short.valueOf(dateData[1]),
                        Short.valueOf(dateData[2]),
                        Short.valueOf( dateData[3]),
                        Short.valueOf(dateData[4]),
                        Short.valueOf(dateData[5]),
                        Short.valueOf(dateData[6]),
                        data[2],
                        data[3], 
                        data[4]
            );
    }

    private static LogDTO convertLogDTOFromLog(Log logobj){
        
        return new LogDTO(
            logobj.getLog_uuid(), 
            logobj.getService_name(), 
            logobj.getYear(), 
            logobj.getMonth(), 
            logobj.getDay(),
            logobj.getHour(), 
            logobj.getMinute(), 
            logobj.getSecond(),  
            logobj.getMilisecond(),
            logobj.getMethod_details(), 
            logobj.getMessage(),
            logobj.getLevel()

            );
    }

    private List<LogDTO> convertLogsToLogDTOs(List<Log> allLogs){

        return allLogs
                .stream()
                .map(LogService::convertLogDTOFromLog)
                .collect(Collectors.toList());

    }

    private void isLevelPresent(String level){

        boolean correctLevel = Arrays.asList(LogLevels.values())
                        .stream()
                        .peek(System.out::println)
                        .map(obj -> obj.name())
                        .peek(System.out::println)
                        .anyMatch( obj -> obj.equals(level));
        
        if(!correctLevel){
            StringBuilder sb = new StringBuilder();
            sb.append("given Level :: ");
            sb.append(level);
            sb.append(" , is not correct as checked ");
            sb.append(" should be in ");
            sb.append(LogLevel.values());
            throw new LogFormatNotCorrect(sb);
        }
    }

    public List<LogDTO> getLogByData(String serviceName,String level,String lastId) throws LogNotFound,LogFormatNotCorrect{

        if(!level.equals("NA")){isLevelPresent(level);}
        
        List<Log> curLogs ;
        StringBuilder sb = new StringBuilder();
        sb.append(" Service Name ");
        sb.append(serviceName);
        if(level.equals("NA") && lastId.equals("NA")){
            curLogs = logRepository.findLogByServiceName(serviceName, logLimit);
        }
        else if(level.equals("NA")  && !lastId.equals("NA")){
            curLogs=logRepository.findLogByServiceNameAndId(serviceName, lastId, logLimit);
            sb.append(" Last Id ");
            sb.append(lastId);
        }
        else  if(!level.equals("NA") && lastId.equals("NA")){
            curLogs=logRepository.findLogByServiceNameAndLevel(serviceName, level, logLimit);
            sb.append(" Level ");
            sb.append(level);
        }else{
            curLogs=logRepository.findLogByServiceNameAndLevelAndId(serviceName, level, lastId, logLimit);
            sb.append(" Level ");
            sb.append(level);
            sb.append("  Last Id ");
            sb.append(lastId);
        }
        if(curLogs.isEmpty()) {
            sb.append(" Not present in Logs please check again ");
            throw new LogNotFound(sb); 
        } 
        return convertLogsToLogDTOs(curLogs);
    }

    public LogDTO getLogById(String logUUID)throws LogNotFound{
        Optional<Log> curLog = logRepository.findLogById(logUUID);
        if(curLog.isEmpty()){
            StringBuilder sb= new StringBuilder();
            sb.append(" Log not Found with ");
            sb.append(logUUID);
            throw new LogNotFound(sb); 
        }
        return convertLogDTOFromLog(curLog.get());
    }

    public  List<String> saveLogs(String[][] logsData)throws LogFormatNotCorrect{
        List<Log> logs = Arrays.stream(logsData)
                            .map(
                                LogService::convertLogFromDTO
                            )
                            .collect(Collectors.toList());
        return logs
                    .stream()
                    .map(obj -> logRepository.save(obj))
                    .map(obj -> obj.getLog_uuid())
                    .collect(Collectors.toList());
        
    }

    public String saveLog(String[] logData){
        return logRepository.save(convertLogFromDTO(logData)).getLog_uuid();
    }
}
