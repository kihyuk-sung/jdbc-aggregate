CREATE TABLE `ORDER` (
    `ID` BIGINT PRIMARY KEY,
    `SHIPPING_ADDRESS` VARCHAR NOT NULL
);

CREATE TABLE `ORDER_ITEM` (
    `ORDER` BIGINT NOT NULL,
    `NAME` VARCHAR NOT NULL,
    `COUNT` INT NOT NULL
);

CREATE INDEX order_item_order_id ON `ORDER_ITEM` (`ORDER`);