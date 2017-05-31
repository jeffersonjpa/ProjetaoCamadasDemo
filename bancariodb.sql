--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.0
-- Dumped by pg_dump version 9.4.0
-- Started on 2017-05-31 08:39:35 -03

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

SET SESSION AUTHORIZATION 'computacao';

DROP DATABASE bancario;
--
-- TOC entry 2266 (class 1262 OID 16488)
-- Name: bancario; Type: DATABASE; Schema: -; Owner: computacao
--

CREATE DATABASE bancario WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'en_US.UTF-8' LC_CTYPE = 'en_US.UTF-8';


\connect bancario

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

SET SESSION AUTHORIZATION 'jefferson';

--
-- TOC entry 5 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: jefferson
--

CREATE SCHEMA public;


--
-- TOC entry 2267 (class 0 OID 0)
-- Dependencies: 5
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: jefferson
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET SESSION AUTHORIZATION DEFAULT;

--
-- TOC entry 174 (class 3079 OID 12123)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2269 (class 0 OID 0)
-- Dependencies: 174
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET SESSION AUTHORIZATION 'bancario';

SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 173 (class 1259 OID 16491)
-- Name: conta; Type: TABLE; Schema: public; Owner: bancario; Tablespace: 
--

CREATE TABLE conta (
    id integer NOT NULL,
    numero character varying NOT NULL,
    saldo double precision NOT NULL
);


--
-- TOC entry 172 (class 1259 OID 16489)
-- Name: Conta_id_seq; Type: SEQUENCE; Schema: public; Owner: bancario
--

CREATE SEQUENCE "Conta_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2272 (class 0 OID 0)
-- Dependencies: 172
-- Name: Conta_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: bancario
--

ALTER SEQUENCE "Conta_id_seq" OWNED BY conta.id;


--
-- TOC entry 2148 (class 2604 OID 16494)
-- Name: id; Type: DEFAULT; Schema: public; Owner: bancario
--

ALTER TABLE ONLY conta ALTER COLUMN id SET DEFAULT nextval('"Conta_id_seq"'::regclass);


--
-- TOC entry 2274 (class 0 OID 0)
-- Dependencies: 172
-- Name: Conta_id_seq; Type: SEQUENCE SET; Schema: public; Owner: bancario
--

SELECT pg_catalog.setval('"Conta_id_seq"', 25, true);


--
-- TOC entry 2261 (class 0 OID 16491)
-- Dependencies: 173
-- Data for Name: conta; Type: TABLE DATA; Schema: public; Owner: bancario
--

INSERT INTO conta (id, numero, saldo) VALUES (8, '9090-Z', 5000);
INSERT INTO conta (id, numero, saldo) VALUES (9, '8080-X', 8000);
INSERT INTO conta (id, numero, saldo) VALUES (10, '7777-x', 7000);
INSERT INTO conta (id, numero, saldo) VALUES (11, '4444-x', 4000);
INSERT INTO conta (id, numero, saldo) VALUES (12, '6666-X', 8000);
INSERT INTO conta (id, numero, saldo) VALUES (13, '8787-X', 8787);
INSERT INTO conta (id, numero, saldo) VALUES (14, '8787-X', 8787);
INSERT INTO conta (id, numero, saldo) VALUES (15, '9000-X', 9000);
INSERT INTO conta (id, numero, saldo) VALUES (16, 'XXXXX', 15000);
INSERT INTO conta (id, numero, saldo) VALUES (17, '1012124-X', 15000);


--
-- TOC entry 2150 (class 2606 OID 18216)
-- Name: id; Type: CONSTRAINT; Schema: public; Owner: bancario; Tablespace: 
--

ALTER TABLE ONLY conta
    ADD CONSTRAINT id PRIMARY KEY (id);


SET SESSION AUTHORIZATION 'jefferson';

--
-- TOC entry 2268 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: jefferson
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM jefferson;
GRANT ALL ON SCHEMA public TO jefferson;
GRANT ALL ON SCHEMA public TO PUBLIC;


SET SESSION AUTHORIZATION 'bancario';

--
-- TOC entry 2270 (class 0 OID 0)
-- Dependencies: 173
-- Name: conta; Type: ACL; Schema: public; Owner: bancario
--

REVOKE ALL ON TABLE conta FROM PUBLIC;
REVOKE ALL ON TABLE conta FROM bancario;
GRANT ALL ON TABLE conta TO bancario;
GRANT ALL ON TABLE conta TO computacao;


SET SESSION AUTHORIZATION 'bancario';

--
-- TOC entry 2271 (class 0 OID 0)
-- Dependencies: 173
-- Name: conta.saldo; Type: ACL; Schema: public; Owner: bancario
--

REVOKE ALL(saldo) ON TABLE conta FROM PUBLIC;
REVOKE ALL(saldo) ON TABLE conta FROM bancario;
GRANT ALL(saldo) ON TABLE conta TO computacao;


SET SESSION AUTHORIZATION 'bancario';

--
-- TOC entry 2273 (class 0 OID 0)
-- Dependencies: 172
-- Name: Conta_id_seq; Type: ACL; Schema: public; Owner: bancario
--

REVOKE ALL ON SEQUENCE "Conta_id_seq" FROM PUBLIC;
REVOKE ALL ON SEQUENCE "Conta_id_seq" FROM bancario;
GRANT ALL ON SEQUENCE "Conta_id_seq" TO bancario;
GRANT ALL ON SEQUENCE "Conta_id_seq" TO computacao;


-- Completed on 2017-05-31 08:39:36 -03

--
-- PostgreSQL database dump complete
--

