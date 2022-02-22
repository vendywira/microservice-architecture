print('Start creating database ##########################')
db = db.getSiblingDB('cart_service_db');
db.createUser(
    {
        user: 'cart-service',
        pwd:  'p@ssw0rd123',
        roles: [{role: 'readWrite', db: 'cart_service_db'}],
    }
);

db = db.getSiblingDB('product_service_db');
db.createUser(
    {
        user: 'product-service',
        pwd:  'p@ssw0rd123',
        roles: [{role: 'readWrite', db: 'product_service_db'}],
    }
);

db = db.getSiblingDB('payment_service_db');
db.createUser(
    {
        user: 'payment-service',
        pwd:  'p@ssw0rd123',
        roles: [{role: 'readWrite', db: 'product_service_db'}],
    }
);
print('End creating database ##########################')