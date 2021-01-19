//Write your code here
        if ("pizza".equals(order)) {
            return new Pizza();
        } else if ("cake".equals(order)) {
            return new Cake();
        }
        return null;