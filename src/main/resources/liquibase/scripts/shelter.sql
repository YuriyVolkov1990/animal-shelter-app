create table cat_shelter(
    id bigserial primary key,
    info text not null,
    guardData text not null,
    recommendation text not null,
    contact text not null
)
create table dog_shelter(
    id bigserial primary key,
    info text not null,
    guardData text not null,
    recommendation text not null,
    contact text not null
)