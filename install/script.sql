--
-- PostgreSQL database dump
--

-- Dumped from database version 13.1
-- Dumped by pg_dump version 13.1

-- Started on 2021-01-22 20:08:23

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

SET default_table_access_method = heap;

--
-- TOC entry 200 (class 1259 OID 24679)
-- Name: class; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.class (
    code bigint NOT NULL,
    description character varying(255) NOT NULL,
    title character varying(255) NOT NULL
);


ALTER TABLE public.class OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 24687)
-- Name: class_students; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.class_students (
    code_class bigint NOT NULL,
    student_id bigint NOT NULL
);


ALTER TABLE public.class_students OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 24692)
-- Name: student; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.student (
    studentid bigint NOT NULL,
    firstname character varying(255) NOT NULL,
    lastname character varying(255) NOT NULL
);


ALTER TABLE public.student OWNER TO postgres;

--
-- TOC entry 2995 (class 0 OID 24679)
-- Dependencies: 200
-- Data for Name: class; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2859 (class 2606 OID 24686)
-- Name: class class_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.class
    ADD CONSTRAINT class_pkey PRIMARY KEY (code);


--
-- TOC entry 2861 (class 2606 OID 24691)
-- Name: class_students class_students_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.class_students
    ADD CONSTRAINT class_students_pkey PRIMARY KEY (code_class, student_id);


--
-- TOC entry 2863 (class 2606 OID 24699)
-- Name: student student_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.student
    ADD CONSTRAINT student_pkey PRIMARY KEY (studentid);




ALTER TABLE ONLY public.class_students
    ADD CONSTRAINT fk1 FOREIGN KEY (code_class) REFERENCES public.class(code) ON UPDATE RESTRICT ON DELETE RESTRICT NOT VALID;

ALTER TABLE ONLY public.class_students
    ADD CONSTRAINT fk2 FOREIGN KEY (student_id) REFERENCES public.student(studentid) ON UPDATE RESTRICT ON DELETE RESTRICT NOT VALID;


-- Completed on 2021-01-22 20:08:24

--
-- PostgreSQL database dump complete
--

INSERT INTO public.class(
	code, description, title)
	VALUES (1, 'matematicas basicas para ni;os', 'matematicas');
INSERT INTO public.class(
	code, description, title)
	VALUES (2, 'lenguaje para jovenes', 'lenguaje');
INSERT INTO public.class(
	code, description, title)
	VALUES (3, 'informatica', 'informatica');
INSERT INTO public.student(
	studentid, firstname, lastname)
	VALUES (1, 'joaquin', 'heredia');
INSERT INTO public.student(
	studentid, firstname, lastname)
	VALUES (2, 'pedro', 'mercado');
INSERT INTO public.student(
	studentid, firstname, lastname)
	VALUES (3, 'juan', 'pinto');
INSERT INTO public.student(
	studentid, firstname, lastname)
	VALUES (4, 'rocio', 'durcal');
INSERT INTO public.class_students(
	code_class, student_id)
	VALUES (1, 1);
	INSERT INTO public.class_students(
	code_class, student_id)
	VALUES (3, 1);
	INSERT INTO public.class_students(
	code_class, student_id)
	VALUES (1, 3);
	INSERT INTO public.class_students(
	code_class, student_id)
	VALUES (2, 3);
	commit;

