package com.bankingportal.controller;

import com.bankingportal.model.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class BankingController {

    private final Map<String, User> users = new HashMap<>();
    private final List<String> transactions = new ArrayList<>();

    private int accountCounter = 100001;

    // REGISTER USER
    @PostMapping("/users/register")
    public String register(@RequestBody RegisterRequest request) {

        String accountNumber = String.valueOf(accountCounter++);

        User user = new User(
                request.getName(),
                request.getEmail(),
                request.getPassword(),
                request.getAddress(),
                request.getPhoneNumber(),
                accountNumber
        );

        users.put(accountNumber, user);

        return "Registration successful. Account Number: "
                + accountNumber;
    }

    // LOGIN
    @PostMapping("/users/login")
    public String login(@RequestBody LoginRequest request) {

        User user = users.get(request.getAccountNumber());

        if (user == null) {
            return "Account not found";
        }

        if (!user.getPassword().equals(request.getPassword())) {
            return "Invalid password";
        }

        return "Login successful";
    }

    // GET USER DETAILS
    @GetMapping("/dashboard/user")
    public User getUserDetails(
            @RequestParam String accountNumber) {

        User user = users.get(accountNumber);

        if (user == null) {
            throw new RuntimeException("User not found");
        }

        return user;
    }

    // GET ACCOUNT DETAILS
    @GetMapping("/dashboard/account")
    public String getAccountDetails(
            @RequestParam String accountNumber) {

        User user = users.get(accountNumber);

        if (user == null) {
            return "Account not found";
        }

        return "Account Number: " + user.getAccountNumber()
                + "\nBalance: " + user.getBalance();
    }

    // CREATE PIN
    @PostMapping("/account/pin/create")
    public String createPin(
            @RequestParam String accountNumber,
            @RequestBody AccountRequest request) {

        User user = users.get(accountNumber);

        if (user == null) {
            return "Account not found";
        }

        if (user.getPin() != null) {
            return "PIN already exists";
        }

        user.setPin(request.getPin());

        return "PIN created successfully";
    }

    // CHECK PIN
    @PostMapping("/account/pin/check")
    public String checkPin(
            @RequestParam String accountNumber,
            @RequestBody AccountRequest request) {

        User user = users.get(accountNumber);

        if (user == null) {
            return "Account not found";
        }

        if (user.getPin() != null &&
                user.getPin().equals(request.getPin())) {

            return "PIN is correct";
        }

        return "Incorrect PIN";
    }

    // UPDATE PIN
    @PostMapping("/account/pin/update")
    public String updatePin(
            @RequestParam String accountNumber,
            @RequestBody Map<String, String> request) {

        User user = users.get(accountNumber);

        if (user == null) {
            return "Account not found";
        }

        String oldPin = request.get("oldPin");
        String newPin = request.get("newPin");

        if (!Objects.equals(user.getPin(), oldPin)) {
            return "Old PIN is incorrect";
        }

        user.setPin(newPin);

        return "PIN updated successfully";
    }

    // DEPOSIT
    @PostMapping("/account/deposit")
    public String deposit(
            @RequestParam String accountNumber,
            @RequestBody AccountRequest request) {

        User user = users.get(accountNumber);

        if (user == null) {
            return "Account not found";
        }

        if (!Objects.equals(user.getPin(), request.getPin())) {
            return "Incorrect PIN";
        }

        if (request.getAmount() <= 0) {
            return "Invalid amount";
        }

        user.setBalance(
                user.getBalance() + request.getAmount()
        );

        transactions.add(
                accountNumber + " deposited "
                        + request.getAmount()
        );

        return "Deposit successful";
    }

    // WITHDRAW
    @PostMapping("/account/withdraw")
    public String withdraw(
            @RequestParam String accountNumber,
            @RequestBody AccountRequest request) {

        User user = users.get(accountNumber);

        if (user == null) {
            return "Account not found";
        }

        if (!Objects.equals(user.getPin(), request.getPin())) {
            return "Incorrect PIN";
        }

        if (request.getAmount() <= 0) {
            return "Invalid amount";
        }

        if (user.getBalance() < request.getAmount()) {
            return "Insufficient balance";
        }

        user.setBalance(
                user.getBalance() - request.getAmount()
        );

        transactions.add(
                accountNumber + " withdrew "
                        + request.getAmount()
        );

        return "Withdrawal successful";
    }

    // FUND TRANSFER
    @PostMapping("/account/fund-transfer")
    public String fundTransfer(
            @RequestParam String accountNumber,
            @RequestBody TransferRequest request) {

        User sender = users.get(accountNumber);
        User receiver =
                users.get(request.getTargetAccountNumber());

        if (sender == null || receiver == null) {
            return "Account not found";
        }

        if (!Objects.equals(sender.getPin(), request.getPin())) {
            return "Incorrect PIN";
        }

        if (request.getAmount() <= 0) {
            return "Invalid amount";
        }

        if (sender.getBalance() < request.getAmount()) {
            return "Insufficient balance";
        }

        sender.setBalance(
                sender.getBalance() - request.getAmount()
        );

        receiver.setBalance(
                receiver.getBalance() + request.getAmount()
        );

        transactions.add(
                accountNumber + " transferred "
                        + request.getAmount()
                        + " to "
                        + request.getTargetAccountNumber()
        );

        return "Fund transfer successful";
    }

    // TRANSACTIONS
    @GetMapping("/account/transactions")
    public List<String> getTransactions() {

        return transactions;
    }
}
