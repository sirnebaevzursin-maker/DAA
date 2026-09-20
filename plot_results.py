import pandas as pd
import matplotlib.pyplot as plt
import numpy as np


data = pd.read_csv("results.csv")


# -----------------------------
# Time vs n
# -----------------------------

plt.figure(figsize=(6, 4))

for algorithm in data["algorithm"].unique():
    temp = data[data["algorithm"] == algorithm]

    plt.plot(
        temp["n"],
        temp["time_ms"],
        marker="o",
        label=algorithm
    )

plt.xlabel("Input size (n)")
plt.ylabel("Time (ms)")
plt.title("Time vs n")
plt.legend()
plt.grid(True)

plt.savefig("time_vs_n.png", dpi=100)
plt.close()



# -----------------------------
# Depth vs n
# -----------------------------

plt.figure(figsize=(6, 4))

for algorithm in data["algorithm"].unique():
    temp = data[data["algorithm"] == algorithm]

    plt.plot(
        temp["n"],
        temp["max_depth"],
        marker="o",
        label=algorithm
    )


plt.xlabel("Input size (n)")
plt.ylabel("Maximum depth")
plt.title("Depth vs n")
plt.legend()
plt.grid(True)

plt.savefig("depth_vs_n.png", dpi=100)
plt.close()



# -----------------------------
# Ratio vs n
# -----------------------------

plt.figure(figsize=(6, 4))


for algorithm in data["algorithm"].unique():

    temp = data[data["algorithm"] == algorithm]

    if algorithm == "QuickSelect":

        ratio = temp["comparisons"] / temp["n"]

    else:

        ratio = temp["comparisons"] / (
            temp["n"] * np.log2(temp["n"])
        )


    plt.plot(
        temp["n"],
        ratio,
        marker="o",
        label=algorithm
    )


plt.xlabel("Input size (n)")
plt.ylabel("Comparison ratio")
plt.title("Ratio vs n")
plt.legend()
plt.grid(True)

plt.savefig("ratio_vs_n.png", dpi=100)
plt.close()


print("Plots created successfully!")
