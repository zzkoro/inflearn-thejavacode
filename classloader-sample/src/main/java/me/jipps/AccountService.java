package me.jipps;

public class AccountService {
    @Inject
    AccountRepository accountRepository;

    public void join() {
        System.out.println("Service.join");
        accountRepository.save();
    }
}
