package com.Mo9u.Mo9u.service;

import com.Mo9u.Mo9u.domain.Sub_manage;
import com.Mo9u.Mo9u.repository.SubManageRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ManageService {

    private final SubManageRepository subManageRepository;
    private final MessageService messageService;

    @Scheduled(cron = "0 15 1 * * *")
    public void checkPaymentDate(){

        LocalDate tomorrow = LocalDate.now().plusDays(1);

        List<Sub_manage> checked = subManageRepository.findAll().stream()
            .filter(s -> s.getCreditDate().isEqual(tomorrow))
            .collect(Collectors.toList());

        for (Sub_manage subManage : checked) {
            String userTel = subManage.getUser().getUserTel();
            String userName = subManage.getUser().getUserName();
            String date = subManage.getCreditDate().toString();
            String subName = subManage.getSubscribe().getName();
            String price = Integer.toString(subManage.getCreditPrice());
            messageService.sendNotificationMessage(userTel, userName, date, subName, price);
        }
    }
}
