--
-- PostgreSQL database dump
--

-- Dumped from database version 11.6 (Ubuntu 11.6-1.pgdg16.04+1)
-- Dumped by pg_dump version 12.0

-- Started on 2020-01-31 20:27:22

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

CREATE TABLE public.comment (
    id_comment bigint NOT NULL,
    id_post bigint NOT NULL,
    id_user bigint NOT NULL,
    text text,
    "createdAt" date
);


CREATE TABLE public.link (
    id_link bigint NOT NULL,
    description character varying(100),
    href character varying(300) NOT NULL
);

CREATE TABLE public.post (
    id_post bigint NOT NULL,
    title character varying(250),
    text text,
    username character varying(300) NOT NULL
);

CREATE SEQUENCE public.sq_comment
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 10000000000000
    CACHE 1;

CREATE SEQUENCE public.sq_link
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 1000000000000
    CACHE 1;

CREATE SEQUENCE public.sq_post
    START WITH 1
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 100000000000
    CACHE 1;

CREATE SEQUENCE public.sq_user_info
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 100000000000000
    CACHE 1;


CREATE TABLE public.user_info (
    id_user_info bigint NOT NULL,
    username character varying(300),
    password character varying(300),
    fullname character varying(300) NOT NULL
);


ALTER TABLE ONLY public.comment
    ADD CONSTRAINT comment_pkey PRIMARY KEY (id_comment);

ALTER TABLE ONLY public.link
    ADD CONSTRAINT link_pkey PRIMARY KEY (id_link, href);

ALTER TABLE ONLY public.post
    ADD CONSTRAINT post_pkey PRIMARY KEY (id_post, username);

ALTER TABLE ONLY public.user_info
    ADD CONSTRAINT unq_username UNIQUE (username);

ALTER TABLE ONLY public.user_info
    ADD CONSTRAINT user_info_pkey PRIMARY KEY (id_user_info, fullname);

REVOKE ALL ON SCHEMA public FROM postgres;
REVOKE ALL ON SCHEMA public FROM PUBLIC;
GRANT ALL ON SCHEMA public TO PUBLIC;

GRANT ALL ON TABLE public.comment TO PUBLIC;

GRANT ALL ON TABLE public.link TO PUBLIC;

GRANT ALL ON TABLE public.post TO PUBLIC;

GRANT ALL ON SEQUENCE public.sq_comment TO PUBLIC;

GRANT ALL ON SEQUENCE public.sq_link TO PUBLIC;

GRANT ALL ON SEQUENCE public.sq_post TO PUBLIC;


GRANT ALL ON SEQUENCE public.sq_user_info TO PUBLIC;

GRANT ALL ON TABLE public.user_info TO PUBLIC;


