PGDMP     +                     {            bit66    15.1    15.1 	    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    24655    bit66    DATABASE     y   CREATE DATABASE bit66 WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Russian_Russia.1251';
    DROP DATABASE bit66;
                postgres    false            �            1259    24666    players    TABLE        CREATE TABLE public.players (
    id integer NOT NULL,
    name character varying NOT NULL,
    surname character varying NOT NULL,
    sex character varying NOT NULL,
    birthday character varying NOT NULL,
    team character varying NOT NULL,
    country character varying NOT NULL
);
    DROP TABLE public.players;
       public         heap    postgres    false            �            1259    24665    players_id_seq    SEQUENCE     �   ALTER TABLE public.players ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.players_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    215            �          0    24666    players 
   TABLE DATA           R   COPY public.players (id, name, surname, sex, birthday, team, country) FROM stdin;
    public          postgres    false    215   %	       �           0    0    players_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.players_id_seq', 22, true);
          public          postgres    false    214            f           2606    24672    players players_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.players
    ADD CONSTRAINT players_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.players DROP CONSTRAINT players_pkey;
       public            postgres    false    215            �   *  x�u�=N�@F��)8����v\S�$$j�R� ,%�Ϗ�D@��aL��}�oo�̂��M�����ͬ&�"�V(����e��N�%(	v�w;�'*�W�Wm�(բ��b0Lη��^w8��3��6��Wv&����j��g���zDe��gng^@�a�ʎ��r�E*�X7��GG����bHX8�ŏkӤ����R�4�0���-V"��#I
�	dX'�I:��pG;�;��U�k��� ���Z��w�0���U�=�m�e����+��5�\Yʹf���V����<�=��9D)v     