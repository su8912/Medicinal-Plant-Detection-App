# 🌿 Smart Application For Medicinal Plant Detection (Aayu)

![Python](https://img.shields.io/badge/Python-3.6-blue?logo=python)
![React Native](https://img.shields.io/badge/React%20Native-Mobile-61DAFB?logo=react)
![TensorFlow](https://img.shields.io/badge/TensorFlow-Keras-FF6F00?logo=tensorflow)
![CNN](https://img.shields.io/badge/Model-CNN%20%7C%20ResNet%20%7C%20AlexNet-green)
![License](https://img.shields.io/badge/License-Academic-lightgrey)
![Status](https://img.shields.io/badge/Status-Completed-brightgreen)

> A deep learning-powered mobile application to identify Ayurvedic medicinal plants from leaf images in real time — bridging ancient herbal knowledge with modern AI.

---

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Tech Stack](#tech-stack)
- [System Architecture](#system-architecture)
- [Model Details](#model-details)
- [Results & Performance](#results--performance)
- [App Screenshots](#app-screenshots)
- [Installation](#installation)
- [Dataset](#dataset)
- [Future Enhancements](#future-enhancements)

---

## 🧠 Overview

Ayurvedic knowledge about medicinal plants is rapidly disappearing from public awareness, especially among younger generations. **Aayu** is a smart mobile application that bridges this gap by letting users **scan a plant leaf** using their phone camera and instantly identify the plant, its medicinal uses, and related herbs.

This project was developed as a **Minor Project** at GSFC University (Semester VI, 2023–24) using Convolutional Neural Networks and transfer learning for image classification.

### Problem Statement
There is no accessible, user-friendly tool for the general public to identify Ayurvedic medicinal plants. This leads to the neglect of a valuable indigenous medicinal system with proven therapeutic benefits.

### Solution
A mobile application powered by CNN/ANN-based image classification that identifies medicinal plants from leaf scans and displays detailed Ayurvedic information.

---

## ✨ Features

| Feature | Description |
|---|---|
| 🔍 **Leaf Scan & Identify** | Scan a leaf using the phone camera to identify the plant species |
| 📚 **Plant Info Lookup** | View detailed Ayurvedic uses, botanical name, family, and treatments |
| 🌱 **Similar Plant Suggestions** | Recommends plants with similar medicinal properties |
| 📍 **Plant Location Tracker** | Geo-tags plant sightings; helps users find plants in emergencies |
| 🌐 **Multi-language Support** | Information available in English and local languages |
| 🧩 **Interactive Quiz** | Knowledge-testing Q&A module for learning about medicinal plants |
| 📷 **Gallery Upload** | Upload from gallery in addition to live camera capture |
| 🔐 **Google Account Login** | Secure authentication via Google Account API |

---

## 🛠️ Tech Stack

### Languages & Frameworks
- **Python 3.6** — Model training and data processing
- **React Native** — Cross-platform mobile UI
- **Java / Android Studio** — Android-specific development

### Machine Learning & AI
- **CNN (Convolutional Neural Network)** — Core image classification architecture
- **AlexNet** — Primary deep learning backbone for leaf recognition
- **ResNet** — Transfer learning for enhanced accuracy
- **GAN (Generative Adversarial Network)** — Data augmentation for limited datasets
- **Transfer Learning** — Fine-tuned pretrained models on custom plant dataset

### Libraries & APIs
- `NumPy`, `OpenCV`, `Keras` — Image preprocessing and model building
- **Google Maps JavaScript API** — Location tracking for plant sightings
- **Google Account API** — User authentication
- **Jupyter Notebook / Google Colab** — Model training environment

### Tools
- Android Studio, VS Code, StarUML, Microsoft Word
- Anaconda Python

---

## 🏗️ System Architecture

The application is built on a **3-layer architecture**:

```
┌─────────────────────────────┐
│     Presentation Layer       │  ← React Native Mobile UI
│  (User Interface / App)      │
└────────────┬────────────────┘
             │
┌────────────▼────────────────┐
│      Domain Logic Layer      │  ← CNN/AlexNet/ResNet Classification
│  (Camera → Model → Results) │     Location, Quiz, Auth Logic
└────────────┬────────────────┘
             │
┌────────────▼────────────────┐
│      Data Storage Layer      │  ← Plant DB | Location DB | Quiz DB
└─────────────────────────────┘
```

---

## 🤖 Model Details

### Architecture
- **Primary Model**: CNN with AlexNet backbone
- **Transfer Learning**: ResNet pretrained weights fine-tuned on medicinal plant dataset
- **Input**: Leaf images (various species, growth stages, environmental conditions)
- **Output**: Multi-class plant species classification

### Training Pipeline
1. **Data Collection** — Diverse dataset across species, growth stages, environments
2. **Data Preprocessing** — Image resizing, noise removal, format standardization
3. **Feature Extraction** — Convolutional layers learn spatial leaf features automatically
4. **Model Training** — Supervised learning with labeled plant category data
5. **Evaluation** — Accuracy, Precision, Recall on validation set
6. **Optimization** — Hyperparameter tuning + Data augmentation
7. **Deployment** — Integrated into React Native mobile app

---

## 📊 Results & Performance

| Metric | Value |
|---|---|
| **Accuracy** | **94%** |
| **Loss** | **1.01%** |
| **Classification Type** | Multi-class (Ayurvedic plant species) |
| **Sample Output** | `Azadirachta Indica (Neem)`, `Mango`, `Lemon`, etc. |

---

## 📱 App Screenshots

| Start Page | Home Page | Main Menu | Scan Page | Result Page |
|---|---|---|---|---|
| Splash with logo | Navigation entry | Scan Leaf / About Us | Camera & Gallery options | Plant name + details |

> **Example Result**: Leaf scanned → Classified as **Azadirachta Indica (Neem)**

---

## ⚙️ Installation

### Prerequisites
- Node.js & npm
- Android Studio
- Python 3.6+
- Anaconda (recommended)

### Clone the Repository
```bash
git clone https://github.com/Surendra-Mahida/<repo-name>.git
cd <repo-name>
```

### Install Python Dependencies
```bash
pip install numpy opencv-python keras tensorflow
```

### Train the Model (Optional)
```bash
jupyter notebook model_training.ipynb
```

### Run Mobile App
```bash
cd mobile-app
npm install
npx react-native run-android
```

---

## 📁 Dataset

- Collected diverse leaf images of Ayurvedic medicinal plant species
- Images span multiple species, growth stages, and environmental conditions
- Data augmentation applied (flipping, rotation, brightness shift) to improve robustness
- Split into training and validation sets

> Dataset not included in repo due to size. Contact the team for access.

---

---

## 🚀 Future Enhancements

- 🤖 **AI-Powered Recommendations** — Personalized plant suggestions using ML
- 👥 **Crowdsourced Contributions** — Community plant data additions
- 🔭 **Augmented Reality (AR)** — Visualize plants in natural habitats via AR
- 🌍 **Offline Mode** — Cache data for use in low-connectivity areas
- 🧬 **Expanded Database** — Add rare and regional Ayurvedic species
- 🗺️ **Advanced Geo-features** — Plant heat maps and discovery trails

---

## 📚 References

1. Alom et al. (2018) — *The History Began from AlexNet: A Comprehensive Survey on Deep Learning Approaches*
2. Bird & Faria (2018) — *A Study on CNN Transfer Learning for Image Classification*
3. Dileep & Pournami (2019) — *AyurLeaf: A Deep Learning Approach for Classification of Medicinal Plants*
4. Jayanka & Fernando (2020) — *Recognising Ayurvedic Herbal Plants in Sri Lanka using CNNs*

---

> ⭐ If you found this project useful, consider giving it a star!
