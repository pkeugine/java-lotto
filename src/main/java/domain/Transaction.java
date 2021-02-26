package domain;

public class Transaction {

    private static final int LOTTO_TICKET_PRICE = 1000;

    private int deposit;
    private int manualQuantity;
    private int autoQuantity;
    private final int original;

    public Transaction(int deposit) {
        validate(deposit);
        this.deposit = deposit;
        this.original = deposit;
    }

    public void buyManualLotto(int count) {
        int totalPrice = LOTTO_TICKET_PRICE * count;
        if (deposit >= totalPrice) {
            deposit -= totalPrice;
            manualQuantity += count;
        }
    }

    public boolean buyAutoLotto() {
        if (deposit < LOTTO_TICKET_PRICE) {
            return false;
        }
        deposit -= LOTTO_TICKET_PRICE;
        ++autoQuantity;
        return true;
    }

    public double calculateTotalProfitRate(int totalProfit) {
        return ((double) totalProfit) / original;
    }

    private void validate(int amount) {
        validatePositive(amount);
    }

    private void validatePositive(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("금액은 음의 정수 값을 가질 수 없습니다.");
        }
    }

    public int getDeposit() {
        return deposit;
    }

    public int getManualQuantity() {
        return manualQuantity;
    }

    public int getAutoQuantity() {
        return autoQuantity;
    }
}